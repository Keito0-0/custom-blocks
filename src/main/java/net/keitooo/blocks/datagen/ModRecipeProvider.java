package net.keitooo.blocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.keitooo.blocks.block.ModBlocks;
import net.keitooo.blocks.item.ModItems;
import net.minecraft.client.color.item.Dye;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> ROSE_GOLD_SMELTABLES = List.of(ModBlocks.CUSTOM_ORE, ModBlocks.DEEPSLATE_CUSTOM_ORE); // list of smeltables

                oreSmelting(ROSE_GOLD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.ROSE_GOLD_ALLOY, 0.25f, 200, "rose_gold"); // smelting
                oreBlasting(ROSE_GOLD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.ROSE_GOLD_ALLOY, 0.25f, 100, "rose_gold"); // blasting

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.ROSE_GOLD_ALLOY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_GOLD_BLOCK); // handles both packing and unpacking (so 1 block into 9 ingots and vice versa)
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.CUSTOM_SHARD, RecipeCategory.MISC, ModBlocks.YELLOW_BLOCK);

                shaped(RecipeCategory.MISC, ModItems.CUSTOM_SHARD)
                        .pattern("XXX")
                        .pattern("XRX")
                        .pattern("XXX")
                        .define('R', Items.AMETHYST_SHARD)
                        .define('X', Items.DYE.yellow())
                        .unlockedBy(getHasName(ModItems.CUSTOM_SHARD), has(ModItems.CUSTOM_SHARD))
                        .group("rose_gold") // recipe book shit
                        .save(output, "custom_shard_from_amethyst_and_yellow_dye");

                shaped(RecipeCategory.MISC, ModItems.ROSE_GOLD_ALLOY)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .define('S', ModItems.ROSE_GOLD_NUGGET)
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_NUGGET), has(ModItems.ROSE_GOLD_NUGGET))
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_ALLOY), has(ModItems.ROSE_GOLD_ALLOY))
                        .group("rose_gold")
                        .save(output, "rose_gold_from_nuggets");

                shapeless(RecipeCategory.MISC, ModItems.ROSE_GOLD_ALLOY, 2)
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.COPPER_INGOT)
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_ALLOY), has(ModItems.ROSE_GOLD_ALLOY))
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.COPPER_INGOT))
                        .group("rose_gold")
                        .save(output, "rose_gold_alloy_from_copper_and_gold");

                stairBuilder(ModBlocks.ROSE_GOLD_STAIRS, Ingredient.of(ModBlocks.ROSE_GOLD_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.ROSE_GOLD_BLOCK), has(ModBlocks.ROSE_GOLD_BLOCK))
                        .group("rose_gold")
                        .save(output);

                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_GOLD_SLAB, ModBlocks.ROSE_GOLD_BLOCK); // category, makes what, out of what

            }
        };
    }

    @Override
    public String getName() {
        return "CustomBlocks Recipes";
    }
}
