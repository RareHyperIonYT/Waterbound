package me.rarehyperion.core.mixin;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ConsumableComponent.class)
public class ConsumableComponentMixin {

    @Inject(
            method = "finishConsumption",
            at = @At(value = "INVOKE", target = "Ljava/util/List;forEach(Ljava/util/function/Consumer;)V")
    )
    public void finishConsumption(final World world, final LivingEntity user, final ItemStack stack, final CallbackInfoReturnable<ItemStack> callback) {
        final Item item = stack.getItem();

        if(item instanceof GlassBottleItem || item instanceof PotionItem) {
            user.setAir(user.getMaxAir());
        }
    }

}
