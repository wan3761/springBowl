package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;

@WanModItem
public class GuaPi extends WanModItemBase implements IHasAModel {

    public GuaPi() {
        this.setRegistryName("spring_bowel:guan_pi").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.guan_pi");
        setMaxStackSize(1);
    }
}
