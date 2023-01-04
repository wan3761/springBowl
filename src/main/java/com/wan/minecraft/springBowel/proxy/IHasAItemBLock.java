package com.wan.minecraft.springBowel.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public interface IHasAItemBLock {
    ItemBlock getItemBlock();
    Block createItemBlock();
}
