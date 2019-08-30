package com.poeticrainbow.crystallinenovelty.block;

import net.minecraft.block.*;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CrystalPedestal extends Block {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 20.0D, 15.0D);
    public CrystalPedestal(Settings block$Settings_1) {
        super(block$Settings_1);
    }
    @Override
    public VoxelShape getCollisionShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
        return SHAPE;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
        return SHAPE;
    }
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    @Override
    public boolean isOpaque(BlockState blockState_1) {
        return false;
    }
}
