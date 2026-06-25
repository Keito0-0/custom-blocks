package net.keitooo.blocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.keitooo.blocks.block.ModBlocks;
import net.keitooo.blocks.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.ROSE_GOLD_BLOCK);

        dropSelf(ModBlocks.SUNSTONE_BLOCK);
        dropSelf(ModBlocks.SUNSTONE_STAIRS);
        add(ModBlocks.SUNSTONE_SLAB, this::createSlabItemTable);
        dropSelf(ModBlocks.SUNSTONE_BUTTON);
        dropSelf(ModBlocks.SUNSTONE_PRESSURE_PLATE);
        dropSelf(ModBlocks.SUNSTONE_FENCE);
        dropSelf(ModBlocks.SUNSTONE_FENCE_GATE);
        dropSelf(ModBlocks.SUNSTONE_WALL);

        add(ModBlocks.SUNSTONE_ORE, createMultipleOreDrops(ModBlocks.SUNSTONE_ORE, ModItems.SUNSTONE, 2, 3));
        add(ModBlocks.DEEPSLATE_SUNSTONE_ORE, createMultipleOreDrops(ModBlocks.DEEPSLATE_SUNSTONE_ORE, ModItems.SUNSTONE, 3, 5));
    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
		HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

		return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
				block, LootItem.lootTableItem(item)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
					.apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))
		);
	}
}
