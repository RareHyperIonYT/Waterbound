package me.rarehyperion;

import me.rarehyperion.core.ItemGroups;
import me.rarehyperion.core.ModBlocks;
import me.rarehyperion.core.ModItems;
import me.rarehyperion.core.ModArmorMaterials;
import me.rarehyperion.core.registry.TooltipRegistry;
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