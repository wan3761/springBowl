package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.listener.SoundRegister;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class FireOpener extends WanModItemBase implements IHasAModel {

    public FireOpener() {
        this.setRegistryName("spring_bowel:fire_opener").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.fire_opener");
        setMaxStackSize(1);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        worldIn.createExplosion(playerIn, playerIn.posX, playerIn.posY, playerIn
                .posZ, 5, true);
        playerIn.playSound(SoundRegister.PUJIPA_SOUND, 1, 1);
        playerIn.setHeldItem(handIn, new ItemStack(Items.AIR));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
