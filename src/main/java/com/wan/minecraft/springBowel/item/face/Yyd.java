package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.item.Item;

public class Yyd extends WanModItemBase  implements IHasAModel {
    public Yyd() {
        this.setRegistryName("spring_bowel:yyd").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.yyd");
    }
}
