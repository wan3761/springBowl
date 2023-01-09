package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.Idea;
import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.listener.SoundRegister;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@WanModItem
public class Qxx extends WanModItemBase implements IHasAModel {
    public Qxx() {
        this.setRegistryName("spring_bowel:qxx").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.qxx");
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        EntityPlayer player = null;
        if (entityIn instanceof EntityPlayer) {
            player = (EntityPlayer) entityIn;
        }
        ItemStack ding = null;
        for (ItemStack itemStack : player.inventory.mainInventory) {
            if (itemStack.getItem() == ItemLists.get(Idea.class)) {


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
