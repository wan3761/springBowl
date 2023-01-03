package com.wan.minecraft.springBowel.proxy;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface INeedInvokeMethodOnRegistry<T extends IForgeRegistryEntry<T>> {
    void onRegistry(RegistryEvent.Register<T> event);
}
