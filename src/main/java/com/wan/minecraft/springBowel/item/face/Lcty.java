package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;

@WanModItem
public class Lcty extends WanModItemBase implements IHasAModel {
    public Lcty() {
        this.setRegistryName("spring_bowel:lcty").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.lcty");
    }
}
