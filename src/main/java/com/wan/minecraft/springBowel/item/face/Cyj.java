package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.item.WanModItemFoodBase;
import com.wan.minecraft.springBowel.listener.SoundRegister;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;

public class Cyj extends WanModItemFoodBase implements IHasAModel {


    public Cyj(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setAlwaysEdible();
        this.setRegistryName("spring_bowel:cyj").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.cyj");
    }

    public Cyj(int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        this.setAlwaysEdible();
        this.setRegistryName("spring_bowel:cyj").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.cyj");
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        EntityPlayer player = null;
        if (entityIn instanceof EntityPlayer) {
            player = (EntityPlayer) entityIn;
        }
        ItemStack ding = null;
        for (ItemStack itemStack : player.inventory.mainInventory) {
            if (itemStack.getItem() == ItemLists.ding) {


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

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        player.playSound(SoundRegister.A_SOUND, 1, 1);
        player.setHealth(0);
        player.setFire(114514);
    }


}
