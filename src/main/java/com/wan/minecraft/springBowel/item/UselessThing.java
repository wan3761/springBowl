package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class UselessThing extends Item {

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.sendMessage(new TextComponentString("you have succeed in building environment. Now noting will stop you in making the mod."));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


    public UselessThing() {
        this.setRegistryName("spring_bowel:uselessItem").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.uselessItem");
    }
}
