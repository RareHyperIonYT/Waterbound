package me.rarehyperion.mixin;

import net.minecraft.item.BucketItem;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BucketItem.class)
public class BucketItemMixin {

    @Redirect(
            method = "placeFluid",
            at = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/world/dimension/DimensionType;ultrawarm()Z"
            )
    )
    public boolean allowNetherPlacement(final DimensionType instance) {
        return false;
    }

}
