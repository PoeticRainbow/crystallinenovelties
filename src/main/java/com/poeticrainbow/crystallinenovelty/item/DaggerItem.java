package com.poeticrainbow.crystallinenovelty.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class DaggerItem extends SwordItem {
    public DaggerItem (ToolMaterial tier, int attackDamageIn, float attackSpeedIn, Item.Settings properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
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
        playerIn.addPotionEffect(new StatusEffectInstance(StatusEffects.STRENGTH, (20 * 10), 1));
        playerIn.addPotionEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, (20 * 5), 0));
        playerIn.getItemCooldownManager().set(this, 600);
        worldIn.playSound((PlayerEntity) null, playerIn.x, playerIn.y, playerIn.z, SoundEvents.BLOCK_BEACON_POWER_SELECT,
                SoundCategory.NEUTRAL, 0.5F, 0.4F / (new Random().nextFloat() * 0.4F + 0.8F));
        playerIn.addChatMessage(new TranslatableText("item.crystallinenovelty.crystal_dagger.use"), true);

        return new TypedActionResult<>(ActionResult.SUCCESS, playerIn.getStackInHand(handIn));
    }
}
