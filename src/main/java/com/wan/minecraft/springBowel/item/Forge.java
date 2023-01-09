package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;

@WanModItem
public class Forge extends WanModItemBase implements IHasAModel {

    public Forge() {
        this.setRegistryName("spring_bowel:forge").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.forge");
    }

}
