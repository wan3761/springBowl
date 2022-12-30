package com.wan.minecraft.springBowel.listener;


import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.command.ItemInfo;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = WanMod.MODID, value = Side.SERVER)
public class CommandRegister {
    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        ClientCommandHandler.instance.registerCommand(new ItemInfo());
        event.registerServerCommand(new ItemInfo());
    }
}
