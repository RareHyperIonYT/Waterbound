package me.rarehyperion.items;

import me.rarehyperion.Waterbound;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.function.Function;

public class ModItems {

    public static Item GLOW_INK_TORCH = register("glow_ink_torch", settings -> new VerticallyAttachableBlockItem(ModBlocks.GLOW_INK_TORCH, ModBlocks.GLOW_INK_WALL_TORCH, Direction.DOWN, settings), new Item.Settings());
    public static Item FLIPPERS = register("flippers", Item::new, new Item.Settings().armor(ArmorMaterials.LEATHER, EquipmentType.BOOTS));

    public static void initialize() {
        Waterbound.LOGGER.info("Registering {} items.", Waterbound.MOD_ID);
    }

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Waterbound.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

}
