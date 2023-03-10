package com.wan.minecraft.springBowel.item.face;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.AnUsbDrive;
import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.item.WanModItemBase;
import com.wan.minecraft.springBowel.item.WanModItemFoodBase;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

@WanModItem
public class Lxh extends WanModItemBase implements IHasAModel {

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.inventory.hasItemStack(new ItemStack(Items.GOLD_INGOT))) {
            NonNullList list = playerIn.inventory.mainInventory;
            int count = -1;

            ItemStack golds = null;

            for (Object itemStack : list) {
                if (itemStack instanceof ItemStack) {
                    ItemStack is = (ItemStack) itemStack;
                    if (is.getItem() == Items.GOLD_INGOT && is.getCount() >= 26) {
                        count = is.getCount() - 26;
                        golds = is;
                        break;
                    }
                }
            }

            if (count < 0) {
                return super.onItemRightClick(worldIn, playerIn, handIn);
            }

            playerIn.inventory.deleteStack(golds);
            playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_INGOT, count));
        } else {
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }
        playerIn.inventory.addItemStackToInventory(new ItemStack( ItemLists.get(AnUsbDrive.class)));
        if (worldIn.isRemote) {
            playerIn.sendMessage(new TextComponentString("??????64G 114Mb/s U?????????"));
            playerIn.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.experience_orb.pickup")), 1, 1);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public Lxh() {
        this.setRegistryName("spring_bowel:lxh").setCreativeTab(WanMod.springBowlFace).setUnlocalizedName("spring_bowel.lxh");
    }
}
