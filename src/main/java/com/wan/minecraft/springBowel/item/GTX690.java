package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class GTX690 extends WanModItemBase implements IHasAModel {

    public GTX690() {
        this.setRegistryName("spring_bowel:GTX690").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.GTX690");
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.setHeldItem(handIn, new ItemStack(Items.AIR));
        playerIn.sendMessage(new TextComponentString("由10万发榴弹推进的饱和打击就可以击沉任何一艘航母"));
        playerIn.sendMessage(new TextComponentString("特别是搭载了GTX690战术核显卡的改进型号"));
        playerIn.sendMessage(new TextComponentString("一发就可以摧毁一个航母战斗群"));
        worldIn.createExplosion(playerIn, playerIn.posX, playerIn.posY, playerIn
                .posZ, 114, true);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
