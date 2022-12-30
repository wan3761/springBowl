package com.wan.minecraft.springBowel.potion;

import com.wan.minecraft.springBowel.WanMod;

public class QuicklyHit extends PotionBase {
    protected QuicklyHit(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        this.setRegistryName(WanMod.MODID, "quickly_hit");
        this.setPotionName("破防");
    }
}
