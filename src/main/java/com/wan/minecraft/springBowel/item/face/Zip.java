package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Zip extends Item {
    public Zip() {
        this.setRegistryName("spring_bowel:zip").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.zip");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.inventory.addItemStackToInventory(new ItemStack(Blocks.YELLOW_SHULKER_BOX).setStackDisplayName("§4小心地滑"));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
