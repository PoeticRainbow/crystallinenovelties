package com.poeticrainbow.crystallinenovelty;

import com.poeticrainbow.crystallinenovelty.block.ModBlocks;
import com.poeticrainbow.crystallinenovelty.entity.ModBlockEntities;
import com.poeticrainbow.crystallinenovelty.item.ModItems;
import com.poeticrainbow.crystallinenovelty.world.OreGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.WildCropFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrystallineNovelty implements ModInitializer {
    public static final String MODID = "crystallinenovelty";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ItemGroup generalItemGroup;

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        ModBlockEntities.init();

        Registry.BIOME.forEach(OreGen::handleBiome);

        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> OreGen.handleBiome(biome));

        Feature<DefaultFeatureConfig> GOOSEBERRY_BUSH = Registry.register(Registry.FEATURE,
                new Identifier(CrystallineNovelty.MODID, "gooseberry_bush"),
                new WildCropFeature(DefaultFeatureConfig::deserialize, (BlockState)ModBlocks.gooseberry_bush.getDefaultState().with(SweetBerryBushBlock.AGE, 3)));
        for(Biome biome : Registry.BIOME) {
            if(biome.getCategory() == Biome.Category.FOREST) {
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(GOOSEBERRY_BUSH, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(3)));
            }
            else if(biome.getCategory() == Biome.Category.PLAINS) {
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(GOOSEBERRY_BUSH, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(2)));
            }
        }
    }

    public static ItemGroup crystallineNovelty = FabricItemGroupBuilder.build(new Identifier(MODID, "general"), () -> new ItemStack(ModBlocks.carnelian_crystal));
}