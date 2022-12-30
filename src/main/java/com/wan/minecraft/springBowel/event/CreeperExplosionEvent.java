package com.wan.minecraft.springBowel.event;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.EntityEvent;

public class CreeperExplosionEvent extends EntityEvent {

    private EntityCreeper creeper;


    public CreeperExplosionEvent(EntityCreeper entity) {
        super(entity);
        creeper = entity;
    }


}
