package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;

@WanModItem
public class Djh extends WanModItemBase implements IHasAModel {
    public Djh() {
        this.setRegistryName("spring_bowel:djh").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.djh");
    }
}
