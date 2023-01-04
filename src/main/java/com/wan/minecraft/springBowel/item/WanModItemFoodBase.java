package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.proxy.IWanModItem;
import net.minecraft.item.ItemFood;

public abstract class WanModItemFoodBase extends ItemFood implements IWanModItem {
    public WanModItemFoodBase(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
    }

    public WanModItemFoodBase(int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
    }
}
