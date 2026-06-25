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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            properties -> new Block(properties
                    .strength(4f) // Breaking time
                    .requiresCorrectToolForDrops() // Drop only when mined with the correct block
                    .sound(SoundType.METAL))); // Place sound

    public static final Block SUNSTONE_BLOCK = registerBlock("sunstone_block",
            properties -> new Block(properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final Block SUNSTONE_ORE = registerBlock("sunstone_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5),properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final Block DEEPSLATE_SUNSTONE_ORE = registerBlock("deepslate_sunstone_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5),properties
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final Block SUNSTONE_STAIRS = registerBlock("sunstone_stairs",
            properties -> new StairBlock(ModBlocks.SUNSTONE_BLOCK.defaultBlockState(), properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final Block SUNSTONE_SLAB = registerBlock("sunstone_slab",
            properties -> new SlabBlock(properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final Block SUNSTONE_BUTTON = registerBlock("sunstone_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 5, properties
                    .strength(1f)
                    .noCollision()
                    .sound(SoundType.METAL)));

    public static final Block SUNSTONE_PRESSURE_PLATE = registerBlock("sunstone_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON, properties
                    .strength(1f)
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.METAL)));




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
