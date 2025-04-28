package me.rarehyperion.core.datagen.impl;

import me.rarehyperion.core.ModBlocks;
import me.rarehyperion.core.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(final BlockStateModelGenerator stateGenerator) {
        stateGenerator.registerTorch(ModBlocks.GLOW_INK_TORCH, ModBlocks.GLOW_INK_WALL_TORCH);

        stateGenerator.registerTintableCross(ModBlocks.GLOW_INK_OAK_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        stateGenerator.registerTintableCross(ModBlocks.GLOW_INK_SPRUCE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(final ItemModelGenerator modelGenerator) {
        modelGenerator.register(ModItems.FLIPPERS, Models.GENERATED); // Will have a player model in the future.
    }

}
