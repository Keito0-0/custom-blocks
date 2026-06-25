package net.keitooo.blocks.block;

import net.keitooo.blocks.CustomBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            properties -> new Block(properties
                    .strength(4f) // Breaking time
                    .requiresCorrectToolForDrops() // Drop only when mined with the correct block
                    .sound(SoundType.METAL))); // Place sound

    public static final Block YELLOW_BLOCK = registerBlock("yellow_block",
            properties -> new Block(properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

public static final Block CUSTOM_ORE = registerBlock("custom_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5),properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

public static final Block DEEPSLATE_CUSTOM_ORE = registerBlock("deepslate_custom_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5),properties
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CustomBlocks.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(CustomBlocks.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(CustomBlocks.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CustomBlocks.MOD_ID, name)))));
    }

    public static void registerModBlocks(){
        CustomBlocks.LOGGER.info("Registering Mod Blocks for " + CustomBlocks.MOD_ID);
    }
}
