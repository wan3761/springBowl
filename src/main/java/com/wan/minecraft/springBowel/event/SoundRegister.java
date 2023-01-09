package com.wan.minecraft.springBowel.event;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = WanMod.MODID)
public class SoundRegister {
    public static final SoundEvent A_SOUND = new SoundEvent(new ResourceLocation(WanMod.MODID, "a_sound")).setRegistryName(new ResourceLocation(WanMod.MODID,"a_sound"));
    public static final SoundEvent PUJIPA_SOUND = new SoundEvent(new ResourceLocation(WanMod.MODID, "pujipa_sound")).setRegistryName(new ResourceLocation(WanMod.MODID,"pujipa_sound"));

    @SubscribeEvent
    public static void onSoundEventRegistration(RegistryEvent.Register<SoundEvent> event){
        event.getRegistry().register(A_SOUND);
        event.getRegistry().register(PUJIPA_SOUND);
    }
}
