package com.poeticrainbow.crystallinenovelty.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class GoldenTopazPedestalEntity extends BlockEntity implements Tickable {
    private int radius = 12;

    public GoldenTopazPedestalEntity() {
        super(ModBlockEntities.GOLDEN_TOPAZ_PEDESTAL_ENTITY);
    }

    public List<LivingEntity> getLivingEntities(World world) {
        if (getWorld().getTime() % 20 == 0) {
            List<Entity> entities = new ArrayList<Entity>();
            Box box = new Box(getPos().getX() - radius, getPos().getY(), getPos().getZ() - radius, getPos().getX() + radius, getPos().getY() + radius, getPos().getZ() + radius);

            return world.getEntities(LivingEntity.class, box);
        }
        return null;
    }

    @Override
    public void tick() {
        if (getWorld().getTime() % 20 == 0) {
            for (LivingEntity entity : getLivingEntities(getWorld())) {
                entity.removePotionEffect(StatusEffects.POISON);
                entity.removePotionEffect(StatusEffects.HUNGER);
                entity.removePotionEffect(StatusEffects.BAD_OMEN);
                entity.removePotionEffect(StatusEffects.WEAKNESS);
                entity.removePotionEffect(StatusEffects.BLINDNESS);
                entity.removePotionEffect(StatusEffects.MINING_FATIGUE);
                entity.removePotionEffect(StatusEffects.NAUSEA);
                entity.removePotionEffect(StatusEffects.WITHER);
            }
        }
    }
}


