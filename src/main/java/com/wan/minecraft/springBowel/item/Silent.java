package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraft.item.Item;

public class Silent extends Item {

    public Silent() {
        this.setRegistryName("spring_bowel:silent").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.silent");
        setMaxStackSize(1);
    }

}
