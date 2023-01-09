package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;

@WanModItem
public class Idea extends WanModItemBase implements IHasAModel {

    public Idea() {
        this.setRegistryName("spring_bowel:idea").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.idea");
    }

}
