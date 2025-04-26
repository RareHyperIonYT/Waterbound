package me.rarehyperion.core.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Redirect(
			method = "baseTick()V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/entity/LivingEntity;isSubmergedIn(Lnet/minecraft/registry/tag/TagKey;)Z"
			)
	)
	private boolean invertDrowning(final LivingEntity self, final TagKey<Fluid> tag) {
		if (self instanceof PlayerEntity && tag == FluidTags.WATER) {
			final World world = self.getWorld();
			final BlockPos position = self.getBlockPos();

			boolean isSubmerged = self.isSubmergedIn(tag);
			boolean isRaining = world.isRaining() && world.isSkyVisible(position) && world.getBiome(position).value().hasPrecipitation();

			return !(isSubmerged || isRaining);
		}

		return self.isSubmergedIn(tag);
	}

	@Redirect(
			method = "baseTick()V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/server/world/ServerWorld;sendEntityStatus(Lnet/minecraft/entity/Entity;B)V"
			)
	)
	private void suppressBubbleParticles(final ServerWorld instance, final Entity entity, final byte status) {
		if (!(entity instanceof PlayerEntity) || status != EntityStatuses.ADD_BUBBLE_PARTICLES) {
			instance.sendEntityStatus(entity, status);
		}
	}

}