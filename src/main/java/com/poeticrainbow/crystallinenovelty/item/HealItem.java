package com.poeticrainbow.crystallinenovelty.item;

import com.poeticrainbow.crystallinenovelty.CrystallineNovelty;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class HealItem extends Item {
    public HealItem (Settings properties) {
        super(new Item.Settings().maxCount(1).group(CrystallineNovelty.crystallineNovelty));
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
    public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addPotionEffect(new StatusEffectInstance(StatusEffects.REGENERATION, (20 * 3),2));
        playerIn.getItemCooldownManager().set(this, 300);
        worldIn.playSound((PlayerEntity)null, playerIn.x, playerIn.y, playerIn.z, SoundEvents.BLOCK_BEACON_POWER_SELECT,
                SoundCategory.NEUTRAL, 0.5F, 0.4F / (new Random().nextFloat() * 0.4F + 0.8F));
        playerIn.addChatMessage(new TranslatableText("item.crystallinenovelty.heal_charm.use"), true);

        return new TypedActionResult<>(ActionResult.SUCCESS, playerIn.getStackInHand(handIn));
    }
}
