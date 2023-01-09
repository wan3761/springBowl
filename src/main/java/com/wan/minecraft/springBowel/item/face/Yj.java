package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.DingDing;
import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.item.WanModItemFoodBase;
import com.wan.minecraft.springBowel.potion.PotionLists;
import com.wan.minecraft.springBowel.potion.Silent;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
@WanModItem
public class Yj extends WanModItemFoodBase implements IHasAModel {

    public Yj(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setAlwaysEdible();
        this.setRegistryName("spring_bowel:yj").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.yj");
    }

    public Yj(){
        this(5, true);
    }

    public Yj(int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        this.setAlwaysEdible();
        this.setRegistryName("spring_bowel:yj").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.yj");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        player.addPotionEffect(new PotionEffect(PotionLists.NONSENSE, 114, 514));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 114, 514));
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
        EntityPlayer player = entityIn instanceof EntityPlayer ? (EntityPlayer) entityIn : null;

        if (player == null) {
            return;
        }

        boolean a = false;
        boolean b = false;
        for (ItemStack itemStack : player.inventory.mainInventory) {
            a = false;
            if (itemStack.getItem() == ItemLists.get(DingDing.class)) {
                a = true;
            }
            if (itemStack.getItem() == ItemLists.get(com.wan.minecraft.springBowel.item.Silent.class)) {
                b = true;
            }
        }
        if (a) {
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 60, 2));
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 60, 5));
        }
        if (!b && !player.getActivePotionMap().containsKey(PotionLists.silent)) {
            player.addPotionEffect(PotionLists.silent.getEffect(6000, 1));
        }

        if (b){
            player.removeActivePotionEffect(PotionLists.silent);
        }

    }
}
