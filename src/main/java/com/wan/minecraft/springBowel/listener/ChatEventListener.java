package com.wan.minecraft.springBowel.listener;

import com.wan.minecraft.springBowel.potion.PotionLists;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.command.server.CommandBanIp;
import net.minecraft.command.server.CommandBanPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class ChatEventListener {

    private static String getRandomChar() {
        String str = "";
        int highCode;
        int lowCode;

        Random random = new Random();

        highCode = (176 + Math.abs(random.nextInt(39)));
        lowCode = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highCode)).byteValue();
        b[1] = (Integer.valueOf(lowCode)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerSendMessage(CommandEvent event) {
        boolean hasDeafPotion = false;
        EntityPlayer player = null;
        if (event.getSender().getCommandSenderEntity() instanceof EntityPlayer) {
            player = (EntityPlayer) event.getSender().getCommandSenderEntity();
        }
        if (player == null) {
            return;
        }

        for (PotionEffect potionEffect : player.getActivePotionEffects()) {
            if (potionEffect.getPotion().equals(PotionLists.deaf)) {
                hasDeafPotion = true;
                break;
            }
        }
        if (hasDeafPotion) {
            event.setCanceled(true);
            player.sendMessage(new TextComponentString("兄弟啊，哑吧怎么会说话啊（恼）"));
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerSendMessage(ServerChatEvent event) {
        boolean hasDeafPotion = false;
        boolean hasNon = false;
        boolean hasSilent = false;
        for (PotionEffect potionEffect : event.getPlayer().getActivePotionEffects()) {
            if (potionEffect.getPotion().equals(PotionLists.deaf)) {
                hasDeafPotion = true;
            }
            if (potionEffect.getPotion().equals(PotionLists.NONSENSE)) {
                hasNon = true;
            }
            if (potionEffect.getPotion().equals(PotionLists.silent)) {
                hasSilent = true;
            }
        }
        if (hasDeafPotion) {
            event.setCanceled(true);
            event.getPlayer().sendMessage(new TextComponentString("兄弟啊，哑吧怎么会说话啊(恼)"));
        } else if (hasNon) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < Math.random() * 30 + 5; i++) {
                word.append(getRandomChar());
            }
            event.setComponent(new TextComponentString(word.toString()));
        }
        if (!hasDeafPotion && hasSilent) {
            event.getPlayer().addPotionEffect(PotionLists.silent.getEffect(6000, 1));
        }
    }
}
