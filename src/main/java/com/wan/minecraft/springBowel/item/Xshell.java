package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;

@WanModItem
public class Xshell extends WanModItemBase implements IHasAModel {

    public Xshell() {
        this.setRegistryName("spring_bowel:xshell").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.xshell");
    }

}
