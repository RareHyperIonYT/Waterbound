package me.rarehyperion.core;

import me.rarehyperion.Waterbound;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {

    public static final ItemGroup WATERBOUND = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.FLIPPERS))
            .displayName(Text.translatable("itemGroup.waterbound.waterbound"))
            .entries((context, entries) -> {
                entries.add(ModItems.GLOW_INK_TORCH);
                entries.add(ModItems.FLIPPERS);
                entries.add(ModItems.GLOW_INK_OAK_SAPLING);
                entries.add(ModItems.GLOW_INK_SPRUCE_SAPLING);
            }).build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(Waterbound.MOD_ID, "waterbound"), WATERBOUND);
    }

}
