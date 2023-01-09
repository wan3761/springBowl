package com.wan.minecraft.springBowel.listener;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IWanModItem;
import com.wan.minecraft.springBowel.item.ItemLists;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = WanMod.MODID)
public class ItemRegister {
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        for (Item item : ItemLists.allItems()) {
            //WanMod.logger.info(item.getRegistryName());
            if (item instanceof IWanModItem){
                ((IWanModItem) item).registryMyself(event);
            }else {
                event.getRegistry().register(item);
            }
        }

    }
}
