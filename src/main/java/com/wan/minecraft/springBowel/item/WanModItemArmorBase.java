package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.proxy.IWanModItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public abstract class WanModItemArmorBase extends ItemArmor implements IWanModItem {
    public WanModItemArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
    }

}
