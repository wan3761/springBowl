package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nullable;

@WanModItem
public class PasswordPaper extends WanModItemBase implements IHasAModel {
    public PasswordPaper(){
        this.setRegistryName(WanMod.MODID,"password_paper").setUnlocalizedName("spring_bowel.password_paper");
        this.setCreativeTab(WanMod.springBowl);
        this.setMaxStackSize(1);
    }



    @Override
    public void registryModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation((Item)this, 0, new ModelResourceLocation(Items.PAPER.getRegistryName(), "inventory"));
    }
}
