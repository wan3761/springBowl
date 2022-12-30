package com.wan.minecraft.springBowel.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@Mod.EventBusSubscriber
public class KeyBroadListener {
    @SubscribeEvent
    public static void onKeyBoardInput(InputEvent.KeyInputEvent event) {

    }
}
