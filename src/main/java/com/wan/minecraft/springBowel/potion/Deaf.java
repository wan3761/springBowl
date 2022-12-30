package com.wan.minecraft.springBowel.potion;

import com.wan.minecraft.springBowel.WanMod;

public class Deaf extends PotionBase {
    protected Deaf(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        this.setRegistryName(WanMod.MODID, "deaf");
        this.setPotionName("哑吧");
    }
}
