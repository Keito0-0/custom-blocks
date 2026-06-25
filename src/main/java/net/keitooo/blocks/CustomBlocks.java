package net.keitooo.blocks;

import net.fabricmc.api.ModInitializer;

import net.keitooo.blocks.block.ModBlocks;
import net.keitooo.blocks.creativemodetab.ModCreativeModeTabs;
import net.keitooo.blocks.item.ModItems;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomBlocks implements ModInitializer {
	public static final String MOD_ID = "custom-blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier toId(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
