package me.rarehyperion.core.datagen;

import me.rarehyperion.core.datagen.impl.ModLootTableProvider;
import me.rarehyperion.core.datagen.impl.ModModelProvider;
import me.rarehyperion.core.datagen.impl.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class WaterboundDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(final FabricDataGenerator generator) {
        final FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModModelProvider::new);
    }

}
