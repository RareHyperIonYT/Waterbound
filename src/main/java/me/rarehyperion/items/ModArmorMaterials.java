package me.rarehyperion.items;

import me.rarehyperion.Waterbound;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterials {

    public static final ArmorMaterial FLIPPER = create("flipper", 5, Map.of(EquipmentType.BOOTS, 1), 5, 0.0F, 0.0F, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, null);

    public static ArmorMaterial create(final String name, final int baseDurability, final Map<EquipmentType, Integer> defenseMap, final int enchantValue, final float toughness, final float knockbackResistance, final RegistryEntry<SoundEvent> equipSound, final TagKey<Item> repairIngredient) {
        final RegistryKey<EquipmentAsset> assetId = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Waterbound.MOD_ID, name));

        return new ArmorMaterial(
                baseDurability,
                defenseMap,
                enchantValue,
                equipSound,
                toughness,
                knockbackResistance,
                repairIngredient,
                assetId
        );
    }

    public static void initialize() {
        Waterbound.LOGGER.info("Registering {} armor materials.", Waterbound.MOD_ID);
    }

}
