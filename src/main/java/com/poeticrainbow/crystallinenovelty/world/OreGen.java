package com.poeticrainbow.crystallinenovelty.world;

import com.poeticrainbow.crystallinenovelty.block.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class OreGen {
    public static void handleBiome(Biome biome) {
        if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NATURAL_STONE,
                                    ModBlocks.carnelian_ore.getDefaultState(),
                                    4 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    4, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    24 //Max y level
                            )));
        }
        if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NATURAL_STONE,
                                    ModBlocks.golden_topaz_ore.getDefaultState(),
                                    4 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    4, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    24 //Max y level
                            )));
        }
    }
}
