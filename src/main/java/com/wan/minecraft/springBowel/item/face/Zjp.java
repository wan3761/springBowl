package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.item.WanModItemFoodBase;
import com.wan.minecraft.springBowel.listener.SoundRegister;
import com.wan.minecraft.springBowel.potion.PotionLists;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Zjp extends WanModItemFoodBase implements IHasAModel {
    public Zjp(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setAlwaysEdible();
        this.setRegistryName("spring_bowel:zjp").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.zjp");
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        EntityPlayer player = null;
        if (entityIn instanceof EntityPlayer) {
            player = (EntityPlayer) entityIn;
        }
        ItemStack ding = null;
        for (ItemStack itemStack : player.inventory.mainInventory) {
            if (itemStack.getItem() == ItemLists.xshell) {


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

    public Zjp(int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        this.setAlwaysEdible();
        this.setRegistryName("spring_bowel:zjp").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.zjp");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 1145, 1));
        player.addPotionEffect(new PotionEffect(PotionLists.deaf, 1919, 1));
        super.onFoodEaten(stack, worldIn, player);
    }
}
