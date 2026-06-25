package net.keitooo.blocks;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.keitooo.blocks.datagen.ModBlockLootTableProvider;
import net.keitooo.blocks.datagen.ModBlockTagsProvider;
import net.keitooo.blocks.datagen.ModModelProvider;
import net.keitooo.blocks.datagen.ModRecipeProvider;

public class CustomBlocksDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
