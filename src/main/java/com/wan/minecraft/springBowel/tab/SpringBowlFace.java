package com.wan.minecraft.springBowel.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SpringBowlFace extends CreativeTabs {
    public SpringBowlFace(String label) {
        super(label);
    }

    public SpringBowlFace(int index, String label) {
        super(index, label);
    }


    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.BOWL);
    }
}
