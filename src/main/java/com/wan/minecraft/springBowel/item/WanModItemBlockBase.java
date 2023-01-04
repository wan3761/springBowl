package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.proxy.IWanModItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public abstract class WanModItemBlockBase extends ItemBlock implements IWanModItem {
    public WanModItemBlockBase(Block block) {
        super(block);
    }

}
