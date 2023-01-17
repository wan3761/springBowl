package com.wan.minecraft.springBowel.potion;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public abstract class PotionBase extends Potion {

    protected PotionBase(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
    }

    public PotionEffect getEffect(int time, int level) {
        return new PotionEffect(this, time, level,false,false);
    }
}
