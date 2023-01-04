package com.wan.minecraft.springBowel.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public interface IWanBlock {
    default void registryMyself(RegistryEvent.Register<Block> event) {
        event.getRegistry().register((Block)this);
    }
}
