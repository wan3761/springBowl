package com.wan.minecraft.springBowel.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SpringBowl extends CreativeTabs {
    public SpringBowl(String label) {
        super(label);
    }

    public SpringBowl(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.BOWL);
    }


}
