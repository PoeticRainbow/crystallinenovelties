package com.poeticrainbow.crystallinenovelty.entity;

import com.poeticrainbow.crystallinenovelty.CrystallineNovelty;
import com.poeticrainbow.crystallinenovelty.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static BlockEntityType CARNELIAN_PEDESTAL_ENTITY;
    public static BlockEntityType GOLDEN_TOPAZ_PEDESTAL_ENTITY;

    public static void init() {
        CARNELIAN_PEDESTAL_ENTITY = register("carnelian_crystal_pedestal", CarnelianPedestalEntity::new, ModBlocks.carnelian_crystal_pedestal);
        GOLDEN_TOPAZ_PEDESTAL_ENTITY = register("golden_topaz_crystal_pedestal", GoldenTopazPedestalEntity::new, ModBlocks.golden_topaz_crystal_pedestal);
    }

    private static BlockEntityType register(String name, Supplier<BlockEntity> blockEntity, Block... block) {
        return Registry.register(Registry.BLOCK_ENTITY, new Identifier(CrystallineNovelty.MODID, name), BlockEntityType.Builder.create(blockEntity, block).build(null));
    }
}
