package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;

@WanModItem
public class Gyf extends WanModItemBase implements IHasAModel {
    public Gyf() {
        this.setRegistryName("spring_bowel:gyf").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.gyf");
    }
}
