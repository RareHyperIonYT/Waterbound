package me.rarehyperion.mixin;

import me.rarehyperion.Waterbound;
import me.rarehyperion.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow public abstract void remove(final Entity.RemovalReason reason);

    @Redirect(
            method = "getBlockBreakingSpeed",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;isSubmergedIn(Lnet/minecraft/registry/tag/TagKey;)Z"
            )
    )
    private boolean disableSlowMine(final PlayerEntity instance, final TagKey<Fluid> tagKey) {
        return false;
    }

    @Redirect(
            method = "getBlockBreakingSpeed",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;isOnGround()Z"
            )
    )
    private boolean disableSlowMine(final PlayerEntity instance) {
        return instance.isOnGround() || instance.isSubmergedIn(FluidTags.WATER);
    }

    @ModifyConstant(
            method = "tickMovement()V",
            constant = @Constant(floatValue = 0.0F, ordinal = 0)
    )
    private float replaceZeroWithCustom(float original) {
        PlayerEntity self = (PlayerEntity)(Object)this;

        if(self.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.FLIPPERS && self.isSwimming()) {
            self.setVelocity(self.getVelocity().multiply(1.05, 1, 1.05)); // It's really weird using mixins for the functionality. Why did they remove ArmorItem?
            return 0.05F;
        }

        return original;
    }



}
