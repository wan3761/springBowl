package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class AnUsbDrive extends WanModItemBase implements IHasAModel {
    public AnUsbDrive() {
        this.setRegistryName("spring_bowel:usb").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.usb");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote) {
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }
        playerIn.sendMessage(new TextComponentString("真实容量：1Gb  "));
        playerIn.sendMessage(new TextComponentString("写入速度：1Mb/s  "));
        playerIn.sendMessage(new TextComponentString("读取速度：30Mb/s  "));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
