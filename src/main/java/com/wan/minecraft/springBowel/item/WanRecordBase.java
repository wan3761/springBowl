package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IWanModItem;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class WanRecordBase extends ItemRecord implements IWanModItem {
    public WanRecordBase(String p_i46742_1_, SoundEvent soundIn) {
        super(p_i46742_1_, soundIn);
        this.setCreativeTab(WanMod.springBowl);
    }
}
