package me.rarehyperion;

import me.rarehyperion.items.ModBlocks;
import me.rarehyperion.items.ModItems;
import me.rarehyperion.items.ModArmorMaterials;
import me.rarehyperion.registry.TooltipRegistry;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Waterbound implements ModInitializer {

	public static final String MOD_ID = "waterbound";
	public static final Logger LOGGER = LoggerFactory.getLogger("Waterbound");

	@Override
	public void onInitialize() {
		ModArmorMaterials.initialize();

		ModBlocks.initialize();
		ModItems.initialize();
		ItemGroups.initialize();

		TooltipRegistry.registerTooltips();
	}

}