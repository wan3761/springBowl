package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraft.item.Item;

public class GuaPi extends Item {

    public GuaPi() {
        this.setRegistryName("spring_bowel:guan_pi").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.guan_pi");
        setMaxStackSize(1);
    }
}
