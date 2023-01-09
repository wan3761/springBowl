package com.wan.minecraft.springBowel.listener;

import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.potion.PotionLists;
import com.wan.minecraft.springBowel.potion.Silent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PotionExpiryEventListener {
    @SubscribeEvent
    public static void onPotionExpiry(PotionEvent.PotionExpiryEvent event) {
        if (PotionLists.silent.equals(event.getPotionEffect().getPotion())) {
            if (event.getEntity() instanceof EntityPlayer) {
                boolean a = false;
                for (ItemStack itemStack : ((EntityPlayer) event.getEntity()).inventory.mainInventory) {
                    if (itemStack.getItem() == ItemLists.get(Silent.class)) a = true;
                }
                if (a) return;
                ((EntityPlayer) event.getEntity()).inventory.addItemStackToInventory(new ItemStack(ItemLists.get(Silent.class)));
                ((EntityPlayer) event.getEntity()).sendMessage(new TextComponentString("你已被给予沉默*1"));
            }
        }
    }
}
