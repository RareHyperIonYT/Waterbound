package me.rarehyperion.core;

import me.rarehyperion.Waterbound;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.function.Function;

public class ModItems {

    public static final Item GLOW_INK_TORCH = register("glow_ink_torch", settings -> new VerticallyAttachableBlockItem(ModBlocks.GLOW_INK_TORCH, ModBlocks.GLOW_INK_WALL_TORCH, Direction.DOWN, settings), new Item.Settings());
    public static final Item FLIPPERS = register("flippers", Item::new, new Item.Settings().armor(ModArmorMaterials.FLIPPER, EquipmentType.BOOTS));
    public static final Item GLOW_INK_OAK_SAPLING = register("glow_ink_oak_sapling", settings -> new BlockItem(ModBlocks.GLOW_INK_OAK_SAPLING, settings), new Item.Settings());
    public static final Item GLOW_INK_SPRUCE_SAPLING = register("glow_ink_spruce_sapling", settings -> new BlockItem(ModBlocks.GLOW_INK_SPRUCE_SAPLING, settings), new Item.Settings());

    public static void initialize() {
        Waterbound.LOGGER.info("Registering {} items.", Waterbound.MOD_ID);
    }

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Waterbound.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

}
