package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;

@WanModItem
public class Ghq extends WanModItemBase implements IHasAModel {
    public Ghq() {
        this.setRegistryName("spring_bowel:ghq").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.ghq");
    }
}
