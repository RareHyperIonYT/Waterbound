package me.rarehyperion.core.datagen.impl;

import me.rarehyperion.core.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(final FabricDataOutput dataOutput, final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.addDrop(ModBlocks.GLOW_INK_TORCH);
        this.addDrop(ModBlocks.GLOW_INK_WALL_TORCH);
        this.addDrop(ModBlocks.GLOW_INK_OAK_SAPLING);
        this.addDrop(ModBlocks.GLOW_INK_SPRUCE_SAPLING);
    }
}
