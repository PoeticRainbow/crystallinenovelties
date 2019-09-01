package com.poeticrainbow.crystallinenovelty.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CarnelianPedestalEntity extends BlockEntity implements Tickable {
    private int radius = 12;

    public CarnelianPedestalEntity() {
        super(ModBlockEntities.CARNELIAN_PEDESTAL_ENTITY);
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
                entity.addPotionEffect(new StatusEffectInstance(StatusEffects.REGENERATION, (20 * 3), 1, true, false, true));
            }
        }
    }
}


