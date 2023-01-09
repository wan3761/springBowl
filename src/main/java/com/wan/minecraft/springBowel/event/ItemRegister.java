package com.wan.minecraft.springBowel.event;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.block.BlockLists;
import com.wan.minecraft.springBowel.item.ItemLists;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = WanMod.MODID)
public class ItemRegister {
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event){
        BlockLists.BlockList.containsKey(""); // for load class
        for(Class c : ItemLists.ItemList.keySet()){
            Item item = ItemLists.get(c);
                    event.getRegistry().register(item);
        }
    }
}
