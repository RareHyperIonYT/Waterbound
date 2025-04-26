package me.rarehyperion.core.registry;

import me.rarehyperion.core.ModItems;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public final class TooltipRegistry {

    public static void registerTooltips() {
        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if(itemStack.isOf(ModItems.FLIPPERS)) {
                list.subList(1, list.size()).clear();
                list.add(Text.translatable("item.waterbound.flippers.tooltip").formatted(Formatting.GRAY, Formatting.ITALIC));
            }
        }));
    }

}
