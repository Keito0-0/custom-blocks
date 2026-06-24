package net.keitooo.blocks;

import net.fabricmc.api.ModInitializer;

import net.keitooo.blocks.item.ModItems;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomBlocks implements ModInitializer {
	public static final String MOD_ID = "custom-blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
