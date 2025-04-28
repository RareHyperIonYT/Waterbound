package me.rarehyperion.core.datagen.impl;

import me.rarehyperion.core.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(final RegistryWrapper.WrapperLookup wrapperLookup, final RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                this.createShapeless(RecipeCategory.DECORATIONS, ModItems.GLOW_INK_TORCH)
                        .input(Items.TORCH)
                        .input(Items.GLOW_INK_SAC)
                        .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                        .offerTo(this.exporter);

                this.createShapeless(RecipeCategory.MISC, ModItems.GLOW_INK_OAK_SAPLING)
                        .input(Items.OAK_SAPLING)
                        .input(Items.GLOW_INK_SAC)
                        .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                        .offerTo(this.exporter);

                this.createShapeless(RecipeCategory.MISC, ModItems.GLOW_INK_SPRUCE_SAPLING)
                        .input(Items.SPRUCE_SAPLING)
                        .input(Items.GLOW_INK_SAC)
                        .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                        .offerTo(this.exporter);

                this.createShaped(RecipeCategory.MISC, ModItems.FLIPPERS)
                        .pattern("SLS")
                        .pattern("THT")
                        .input('S', Items.SLIME_BALL)
                        .input('L', Items.LEATHER_BOOTS)
                        .input('T', Items.STRING)
                        .input('H', Items.LEATHER)
                        .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                        .offerTo(this.exporter);

            }
        };
    }

    @Override
    public String getName() {
        return "WaterboundRecipeProvider";
    }

}
