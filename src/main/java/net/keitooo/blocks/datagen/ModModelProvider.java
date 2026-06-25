package net.keitooo.blocks.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.keitooo.blocks.block.ModBlocks;
import net.keitooo.blocks.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        // blockModelGenerators.createTrivialCube(ModBlocks.SUNSTONE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.ROSE_GOLD_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.SUNSTONE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_SUNSTONE_ORE);

        blockModelGenerators.family(ModBlocks.SUNSTONE_BLOCK)
                .stairs(ModBlocks.SUNSTONE_STAIRS)
                .slab(ModBlocks.SUNSTONE_SLAB)
                .button(ModBlocks.SUNSTONE_BUTTON)
                .pressurePlate(ModBlocks.SUNSTONE_PRESSURE_PLATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLD_ALLOY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLD_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SUNSTONE, ModelTemplates.FLAT_ITEM);
    }
}
