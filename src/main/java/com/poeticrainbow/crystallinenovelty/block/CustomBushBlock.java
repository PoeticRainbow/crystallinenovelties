package com.poeticrainbow.crystallinenovelty.block;

import com.poeticrainbow.crystallinenovelty.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CustomBushBlock extends SweetBerryBushBlock {
    public CustomBushBlock(Settings properties) {
        super(properties);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public ItemStack getPickStack(BlockView worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(ModBlocks.gooseberry_bush);
    }

    @Override
    public boolean activate(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getStackInHand(handIn).getItem() == Items.BONE_MEAL) {
            return false;
        } else if (i > 1) {
            int j = 1 + worldIn.getRandom().nextInt(2);
            dropStack(worldIn, pos, new ItemStack(ModBlocks.gooseberry_bush, j + (flag ? 1 : 0)));
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH,
                    SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.getRandom().nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(1)), 2);
            return true;
        } else {
            return super.activate(state, worldIn, pos, player, handIn, hit);
        }
    }
}