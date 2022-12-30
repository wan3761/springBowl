package com.wan.minecraft.springBowel.listener;

import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class OnCreeperExplosionEvent {
    @SubscribeEvent
    public static void onExplosion(ExplosionEvent e) {

    }
}
