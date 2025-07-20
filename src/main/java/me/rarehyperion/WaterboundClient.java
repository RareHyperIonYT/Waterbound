package me.rarehyperion;

import me.rarehyperion.core.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;

public class WaterboundClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.GLOW_INK_OAK_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLOW_INK_SPRUCE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLOW_INK_CHERRY_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLOW_INK_DARK_OAK_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLOW_INK_ACACIA_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLOW_INK_BIRCH_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLOW_INK_JUNGLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLOW_INK_PALE_OAK_SAPLING, BlockRenderLayer.CUTOUT);
    }

}
