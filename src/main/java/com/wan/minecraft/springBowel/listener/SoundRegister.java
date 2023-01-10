package com.wan.minecraft.springBowel.listener;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = WanMod.MODID,value = Side.SERVER)
public class SoundRegister {
    public static final SoundEvent A_SOUND = new SoundEvent(new ResourceLocation(WanMod.MODID, "a_sound")).setRegistryName(new ResourceLocation(WanMod.MODID,"a_sound"));
    public static final SoundEvent PUJIPA_SOUND = new SoundEvent(new ResourceLocation(WanMod.MODID, "pujipa_sound")).setRegistryName(new ResourceLocation(WanMod.MODID, "pujipa_sound"));
    public static final SoundEvent WHERE_IS_MY_BAG = new SoundEvent(new ResourceLocation(WanMod.MODID, "where_is_my_bag")).setRegistryName(new ResourceLocation(WanMod.MODID, "where_is_my_bag"));
    @SubscribeEvent
    public static void onSoundEventRegistration(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(A_SOUND);
        event.getRegistry().register(PUJIPA_SOUND);
        event.getRegistry().register(WHERE_IS_MY_BAG);
    }
}
