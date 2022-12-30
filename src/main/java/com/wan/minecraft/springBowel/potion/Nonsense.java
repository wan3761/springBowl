package com.wan.minecraft.springBowel.potion;

import com.wan.minecraft.springBowel.WanMod;

public class Nonsense extends PotionBase {
    protected Nonsense(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        this.setRegistryName(WanMod.MODID, "nosense");
        this.setPotionName("胡言乱语");
    }

}
