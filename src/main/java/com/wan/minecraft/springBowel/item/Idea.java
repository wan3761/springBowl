package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;

public class Idea extends WanModItemBase implements IHasAModel {

    public Idea() {
        this.setRegistryName("spring_bowel:idea").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.idea");
    }

}
