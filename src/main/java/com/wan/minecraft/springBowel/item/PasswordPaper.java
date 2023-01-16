package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nullable;
import java.util.List;

@WanModItem
public class PasswordPaper extends WanModItemBase implements IHasAModel {
    public PasswordPaper(){
        this.setRegistryName(WanMod.MODID,"password_paper").setUnlocalizedName("spring_bowel.password_paper");
        this.setCreativeTab(WanMod.springBowl);
        this.setMaxStackSize(1);
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.getTagCompound() == null){
            return;
        }
        tooltip.add("密码是"+stack.getTagCompound().getString("pwd"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
