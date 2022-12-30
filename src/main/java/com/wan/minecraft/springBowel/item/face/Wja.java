package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.listener.SoundRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Wja extends Item {
    public Wja() {
        this.setRegistryName("spring_bowel:wja").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.wja");
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        EntityPlayer player = null;
        if (entityIn instanceof EntityPlayer) {
            player = (EntityPlayer) entityIn;
        }
        ItemStack ding = null;
        for (ItemStack itemStack : player.inventory.mainInventory) {
            if (itemStack.getItem() == ItemLists.forge) {


                worldIn.createExplosion(entityIn, entityIn.posX, entityIn.posY, entityIn.posZ, 5, true);
                player.playSound(SoundRegister.PUJIPA_SOUND, 1, 1);

                ding = itemStack;
            }
        }

        if (ding != null) {
            player.inventory.deleteStack(ding);
            player.inventory.deleteStack(stack);
        }

        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
