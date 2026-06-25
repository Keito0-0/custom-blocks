package net.keitooo.blocks.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.keitooo.blocks.CustomBlocks;
import net.keitooo.blocks.block.ModBlocks;
import net.keitooo.blocks.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    // This method adds a new creative mode tab
    public static final CreativeModeTab CUSTOM_ITEMS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(CustomBlocks.MOD_ID, "custom_items"), // Tab ID
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROSE_GOLD_ALLOY)) // Tab icon
                    .title(Component.translatable("creativemodetab.custom-blocks.custom_items")) // Translation key
                    .displayItems((parameters, output) -> { // Items inside the tab
                        output.accept(ModItems.ROSE_GOLD_ALLOY);
                        output.accept(ModItems.ROSE_GOLD_NUGGET);
                        output.accept(ModItems.SUNSTONE);


                    }).build());


    public static final CreativeModeTab CUSTOM_BLOCKS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(CustomBlocks.MOD_ID, "custom_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SUNSTONE_BLOCK))
                    .title(Component.translatable("creativemodetab.custom-blocks.custom_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.SUNSTONE_BLOCK);
                        output.accept(ModBlocks.SUNSTONE_STAIRS);
                        output.accept(ModBlocks.SUNSTONE_SLAB);
                        output.accept(ModBlocks.SUNSTONE_BUTTON);
                        output.accept(ModBlocks.SUNSTONE_PRESSURE_PLATE);
                        output.accept(ModBlocks.SUNSTONE_FENCE);
                        output.accept(ModBlocks.SUNSTONE_FENCE_GATE);
                        output.accept(ModBlocks.SUNSTONE_WALL);

                        output.accept(ModBlocks.ROSE_GOLD_BLOCK);

                        output.accept(ModBlocks.SUNSTONE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_SUNSTONE_ORE);


                    }).build());


    public static void registerModCreativeModeTabs(){
        CustomBlocks.LOGGER.info("Registering Creative Mode Tabs for " + CustomBlocks.MOD_ID);
    }
}
