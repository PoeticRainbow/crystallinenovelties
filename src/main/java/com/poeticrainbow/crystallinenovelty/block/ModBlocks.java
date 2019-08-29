package com.poeticrainbow.crystallinenovelty.block;

import com.poeticrainbow.crystallinenovelty.CrystallineNovelty;
import com.poeticrainbow.crystallinenovelty.item.GooseberryItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static Block carnelian_ore;
    public static Block golden_topaz_ore;
    public static Block carnelian_crystal;
    public static Block golden_topaz_crystal;
    public static Block gooseberry_bush;

    public static void init() {
        carnelian_ore = register("carnelian_ore", new Block(Block.Settings.copy(Blocks.DIAMOND_ORE)));
        golden_topaz_ore = register("golden_topaz_ore", new Block(Block.Settings.copy(Blocks.DIAMOND_ORE)));
        carnelian_crystal = register("carnelian_crystal", new CrystalBlock(Block.Settings.copy(Blocks.GLOWSTONE)));
        golden_topaz_crystal = register("golden_topaz_crystal", new CrystalBlock(Block.Settings.copy(Blocks.GLOWSTONE)));
        gooseberry_bush = register("gooseberry_bush", new CustomBushBlock(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)));
        Registry.register(Registry.ITEM, new Identifier(CrystallineNovelty.MODID, "gooseberries"),
                new GooseberryItem(gooseberry_bush, (new Item.Settings()).group(ItemGroup.FOOD).food(FoodComponents.SWEET_BERRIES)));
    }

    private static BlockItem createBlockItem(Block block) {
        return createBlockItem(block, CrystallineNovelty.generalItemGroup);
    }

    private static BlockItem createBlockItem(Block block, ItemGroup group) {
        return new BlockItem(block, new Item.Settings().group(CrystallineNovelty.crystallineNovelty));
    }

    private static <T extends Block> T register(String name, T block) {
        Registry.register(Registry.BLOCK, new Identifier(CrystallineNovelty.MODID, name), block);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(block), createBlockItem(block));

        return block;
    }

    private static <T extends Block> T register(String name, T block, BlockItem blockItem) {
        Registry.register(Registry.BLOCK, new Identifier(CrystallineNovelty.MODID, name), block);
        Registry.register(Registry.ITEM, new Identifier(CrystallineNovelty.MODID, name), blockItem);

        return block;
    }

    private static <T extends Block> T register(String name, T block, String itemName, BlockItem blockItem) {
        Registry.register(Registry.BLOCK, new Identifier(CrystallineNovelty.MODID, name), block);
        Registry.register(Registry.ITEM, new Identifier(CrystallineNovelty.MODID, itemName), blockItem);

        return block;
    }
}
