package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.item.Item;

public class Yt extends WanModItemBase implements IHasAModel {
    public Yt() {
        this.setRegistryName("spring_bowel:yt").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.yt");
    }
}
