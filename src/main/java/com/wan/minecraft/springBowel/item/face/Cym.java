package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;

@WanModItem
public class Cym extends WanModItemBase implements IHasAModel {
    public Cym() {
        this.setRegistryName("spring_bowel:cym").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.cym");
    }
}
