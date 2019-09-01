package com.poeticrainbow.crystallinenovelty.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class GooseberryItem extends AliasedBlockItem {
    public GooseberryItem(Block block_1, Settings item$Settings_1) {
        super(block_1, item$Settings_1);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(this.getItemDescription().formatted(Formatting.GRAY));
    }

    @Environment(EnvType.CLIENT)
    public Text getItemDescription() {
        return new TranslatableText(this.getTranslationKey() + ".desc");
    }

    @Override
    public ItemStack finishUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1) {
        ItemStack itemStack_2 = super.finishUsing(itemStack_1, world_1, livingEntity_1);
        if (!(livingEntity_1 instanceof PlayerEntity)) {
            return itemStack_2;
        }
        PlayerEntity playerIn = (PlayerEntity) livingEntity_1;
        if (playerIn.getHealth() < (playerIn.getHealthMaximum()/2) && !playerIn.abilities.creativeMode) {
            playerIn.addPotionEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, (1), 1/2));
            playerIn.getItemCooldownManager().set(this, 40);
            world_1.playSound((PlayerEntity) null, playerIn.x, playerIn.y, playerIn.z, SoundEvents.BLOCK_WET_GRASS_FALL,
                    SoundCategory.NEUTRAL, 0.5F, 0.4F / (new Random().nextFloat() * 0.4F + 0.8F));
            playerIn.addChatMessage(new TranslatableText("item.crystallinenovelty.gooseberries.use"), true);
        }
        else {
            playerIn.addChatMessage(new TranslatableText("item.crystallinenovelty.gooseberries.use.fail"), true);
        }
        return itemStack_2;
    }
}
