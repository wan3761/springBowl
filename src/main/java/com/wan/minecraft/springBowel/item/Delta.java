package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Delta extends Item {

    public Delta() {
        this.setRegistryName("spring_bowel:delta").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.delta");
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        entityIn.setFire(10);
        entityIn.setFire(0);
    }
}