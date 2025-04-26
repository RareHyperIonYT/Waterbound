package me.rarehyperion;

import me.rarehyperion.core.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class WaterboundClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        final BlockRenderLayerMap layerMap = BlockRenderLayerMap.INSTANCE;
        layerMap.putBlock(ModBlocks.GLOW_INK_OAK_SAPLING, RenderLayer.getCutout());
        layerMap.putBlock(ModBlocks.GLOW_INK_SPRUCE_SAPLING, RenderLayer.getCutout());
    }

}
