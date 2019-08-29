package com.poeticrainbow.crystallinenovelty.item;

import com.poeticrainbow.crystallinenovelty.CrystallineNovelty;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static Item heal_charm = null;
    public static Item purity_charm = null;
    public static Item crystal_dagger = null;

    public static void init() {
        heal_charm = register("heal_charm", new HealItem(new Item.Settings().group(CrystallineNovelty.crystallineNovelty)));
        purity_charm = register("purity_charm", new PurifyItem(new Item.Settings().group(CrystallineNovelty.crystallineNovelty)));
        crystal_dagger = register("crystal_dagger", new DaggerItem(ToolMaterials.DIAMOND, 0, (float) -2.0,
                new Item.Settings().maxCount(1).group(CrystallineNovelty.crystallineNovelty)));
    }

    private static <T extends Item> T register(String name, T item) {
        Registry.register(Registry.ITEM, new Identifier(CrystallineNovelty.MODID, name), item);

        return item;
    }
}
