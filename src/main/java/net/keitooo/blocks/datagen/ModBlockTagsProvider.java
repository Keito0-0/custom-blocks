package net.keitooo.blocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.keitooo.blocks.CustomBlocks;
import net.keitooo.blocks.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemId;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(TagEntry.element(CustomBlocks.toId("rose_gold_block")))
            .add(TagEntry.element(CustomBlocks.toId("sunstone_ore")))
            .add(TagEntry.element(CustomBlocks.toId("deepslate_sunstone_ore")))
            .add(TagEntry.element(CustomBlocks.toId("sunstone_block")))
            .add(TagEntry.element(CustomBlocks.toId("sunstone_slab")))
            .add(TagEntry.element(CustomBlocks.toId("sunstone_stairs")));

        getOrCreateRawBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(TagEntry.element(CustomBlocks.toId("sunstone_ore")));

        getOrCreateRawBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(TagEntry.element(CustomBlocks.toId("rose_gold_block")))
            .add(TagEntry.element(CustomBlocks.toId("deepslate_sunstone_ore")))
            .add(TagEntry.element(CustomBlocks.toId("sunstone_stairs")))
            .add(TagEntry.element(CustomBlocks.toId("sunstone_slab")));

        getOrCreateRawBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(TagEntry.element(CustomBlocks.toId("sunstone_block")));

        getOrCreateRawBuilder(BlockTags.STAIRS)
            .add(TagEntry.element(CustomBlocks.toId("sunstone_stairs")));
        getOrCreateRawBuilder(BlockTags.SLABS)
            .add(TagEntry.element(CustomBlocks.toId("sunstone_slab")));
        getOrCreateRawBuilder(BlockTags.BUTTONS)
            .add(TagEntry.element(CustomBlocks.toId("sunstone_button")));
        getOrCreateRawBuilder(BlockTags.PRESSURE_PLATES)
            .add(TagEntry.element(CustomBlocks.toId("sunstone_pressure_plate")));

    }
}
