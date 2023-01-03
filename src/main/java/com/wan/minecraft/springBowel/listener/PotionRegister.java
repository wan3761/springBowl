package com.wan.minecraft.springBowel.listener;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.potion.PotionLists;
import com.wan.minecraft.springBowel.proxy.INeedInvokeMethodOnRegistry;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = WanMod.MODID)
public class PotionRegister {
    @SubscribeEvent
    public static void onPotionRegistration(RegistryEvent.Register<Potion> event) {
        for (Potion potion : PotionLists.PotionList) {
            if (potion instanceof INeedInvokeMethodOnRegistry){
                ((INeedInvokeMethodOnRegistry<Potion>) potion).onRegistry(event);
            }
            event.getRegistry().register(potion);
        }
    }
}
