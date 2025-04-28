package me.rarehyperion.core;

import me.rarehyperion.Waterbound;
import me.rarehyperion.feature.blocks.GlowInkSapling;
import me.rarehyperion.feature.blocks.GlowInkTorch;
import me.rarehyperion.feature.blocks.GlowInkWallTorch;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block GLOW_INK_TORCH = register("glow_ink_torch", settings -> new GlowInkTorch(ParticleTypes.FLAME, settings), AbstractBlock.Settings.copy(Blocks.TORCH));
    public static final Block GLOW_INK_WALL_TORCH = register("glow_ink_wall_torch", settings -> new GlowInkWallTorch(ParticleTypes.FLAME, settings), AbstractBlock.Settings.copy(Blocks.TORCH));

    public static final Block GLOW_INK_OAK_SAPLING = register("glow_ink_oak_sapling", settings -> new GlowInkSapling(SaplingGenerator.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));
    public static final Block GLOW_INK_SPRUCE_SAPLING = register("glow_ink_spruce_sapling", settings -> new GlowInkSapling(SaplingGenerator.SPRUCE, settings), AbstractBlock.Settings.copy(Blocks.SPRUCE_SAPLING));
    public static final Block GLOW_INK_CHERRY_SAPLING = register("glow_ink_cherry_sapling", settings -> new GlowInkSapling(SaplingGenerator.CHERRY, settings), AbstractBlock.Settings.copy(Blocks.CHERRY_SAPLING));
    public static final Block GLOW_INK_DARK_OAK_SAPLING = register("glow_ink_dark_oak_sapling", settings -> new GlowInkSapling(SaplingGenerator.DARK_OAK, settings), AbstractBlock.Settings.copy(Blocks.DARK_OAK_SAPLING));
    public static final Block GLOW_INK_ACACIA_SAPLING = register("glow_ink_acacia_sapling", settings -> new GlowInkSapling(SaplingGenerator.ACACIA, settings), AbstractBlock.Settings.copy(Blocks.ACACIA_SAPLING));
    public static final Block GLOW_INK_BIRCH_SAPLING = register("glow_ink_birch_sapling", settings -> new GlowInkSapling(SaplingGenerator.BIRCH, settings), AbstractBlock.Settings.copy(Blocks.BIRCH_SAPLING));
    public static final Block GLOW_INK_JUNGLE_SAPLING = register("glow_ink_jungle_sapling", settings -> new GlowInkSapling(SaplingGenerator.JUNGLE, settings), AbstractBlock.Settings.copy(Blocks.JUNGLE_SAPLING));
    public static final Block GLOW_INK_PALE_OAK_SAPLING = register("glow_ink_pale_oak_sapling", settings -> new GlowInkSapling(SaplingGenerator.PALE_OAK, settings), AbstractBlock.Settings.copy(Blocks.PALE_OAK_SAPLING));

    public static void initialize() {
        Waterbound.LOGGER.info("Registering {} blocks.", Waterbound.MOD_ID);
    }

    private static Block register(final String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(Waterbound.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        return Blocks.register(registryKey, factory, settings);
    }

}
