package net.keitooo.blocks.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.keitooo.blocks.CustomBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item ROSE_GOLD_ALLOY = registerItem("rose_gold_alloy", Item::new); // Registers a new item
    public static final Item ROSE_GOLD_NUGGET = registerItem("rose_gold_nugget", Item::new);
    public static final Item CUSTOM_SHARD = registerItem("custom_shard", Item::new);



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(CustomBlocks.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CustomBlocks.MOD_ID, name)))));
    }

    public static void registerModItems() {
        CustomBlocks.LOGGER.info("Registering Mod Items for " + CustomBlocks.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> { // Adds the item to the specified creative tab
            output.accept(ROSE_GOLD_ALLOY);
            output.accept(ROSE_GOLD_NUGGET);
        });
    }
}
