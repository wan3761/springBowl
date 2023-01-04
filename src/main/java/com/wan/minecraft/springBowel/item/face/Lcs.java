package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.item.Item;

public class Lcs extends WanModItemBase implements IHasAModel {
    public Lcs() {
        this.setRegistryName("spring_bowel:lcs").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.lcs");
    }
}
