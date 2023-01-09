package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

@WanModItem
public class Silent extends WanModItemBase  {

    public Silent() {
        this.setRegistryName("spring_bowel:silent").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.silent");
        setMaxStackSize(1);
    }

}
