package com.wan.minecraft.springBowel.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public interface IWanModItem {
    default void registryMyself(RegistryEvent.Register<Item> event) {
        event.getRegistry().register((Item)this);
    }
}
