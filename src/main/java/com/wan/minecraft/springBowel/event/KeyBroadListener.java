package com.wan.minecraft.springBowel.event;

import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import java.awt.*;
import java.awt.event.KeyEvent;

@Mod.EventBusSubscriber
public class KeyBroadListener {
    @SubscribeEvent
    public static void onKeyBoardInput(InputEvent.KeyInputEvent event){

    }
}
