package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;

@WanModItem
public class Pirce extends WanModItemBase implements IHasAModel {

    public Pirce() {
        this.setRegistryName("spring_bowel:price").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.price");
    }

}
