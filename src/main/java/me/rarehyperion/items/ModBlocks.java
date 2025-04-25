package me.rarehyperion.items;

import me.rarehyperion.Waterbound;
import me.rarehyperion.blocks.GlowInkTorch;
import me.rarehyperion.blocks.GlowInkWallTorch;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block GLOW_INK_TORCH = register("glow_ink_torch", settings -> new GlowInkTorch(ParticleTypes.FLAME, settings), AbstractBlock.Settings.copy(Blocks.TORCH));
    public static final Block GLOW_INK_WALL_TORCH = register("glow_ink_wall_torch", settings -> new GlowInkWallTorch(ParticleTypes.FLAME, settings), AbstractBlock.Settings.copy(Blocks.TORCH));


    public static void initialize() {
        Waterbound.LOGGER.info("Registering {} blocks.", Waterbound.MOD_ID);
    }

    private static Block register(final String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(Waterbound.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        return Blocks.register(registryKey, factory, settings);
    }

}
