package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.block.AndDoor;
import com.wan.minecraft.springBowel.block.BlockLists;
import com.wan.minecraft.springBowel.block.OrDoor;
import com.wan.minecraft.springBowel.block.XorDoor;
import com.wan.minecraft.springBowel.item.face.*;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ItemLists {
    public static final List<Item> ItemList = new ArrayList<>();

    public static final WanModItemBase          uselessThing= new UselessThing();

    public static final WanModItemFoodBase      cyj         = new Cyj(1, true);
    public static final WanModItemBase          cym         = new Cym();
    public static final WanModItemBase          djh         = new Djh();
    public static final WanModItemBase          ghq         = new Ghq();
    public static final WanModItemBase          gyf         = new Gyf();
    public static final WanModItemBase          lcs         = new Lcs();
    public static final WanModItemBase          lcty        = new Lcty();
    public static final WanModItemBase          lxh         = new Lxh();
    public static final WanModItemBase          qxx         = new Qxx();
    public static final WanModItemBase          wja         = new Wja();
    public static final WanModItemBase          yt          = new Yt();
    public static final WanModItemBase          yyd         = new Yyd();
    public static final WanModItemFoodBase      zjp         = new Zjp(1, 5, true);
    public static final WanModItemBase          zip         = new Zip();
    public static final WanModItemFoodBase      yj          = new Yj(1, 5, true);
    public static final WanModItemBase          usb         = new AnUsbDrive();

    public static final WanModItemBase          ding        = new DingDing();
    public static final WanModItemBase          idea        = new Idea();
    public static final WanModItemBase          xshell      = new Xshell();
    public static final WanModItemBase          forge       = new Forge();
    public static final WanModItemBase          fireOpener  = new FireOpener();
    public static final WanModItemBase          gtx690      = new GTX690();
    public static final WanModItemBase          delta       = new Delta();
    public static final WanModItemBase          guaPi       = new GuaPi();
    public static final WanModItemBase          pirce       = new Pirce();
    public static final WanModItemBase          silent      = new Silent();

    public static final WanModItemArmorBase     kingHat     = new KingHatItemBlock(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.HEAD);
    public static final ItemBlock               AND_DOOR    = ((AndDoor)BlockLists.POWER_AND_DOOR).getItemBlock();
    public static final ItemBlock               OR_DOOR     = ((OrDoor)BlockLists.POWER_OR_DOOR).getItemBlock();
    //TODO 以下物品的模型
    public static final ItemBlock               XOR_DOOR    = ((XorDoor)BlockLists.POWER_XOR_DOOR).getItemBlock();
    public static final NotDoor                 NOT_DOOR    = ((com.wan.minecraft.springBowel.block.NotDoor)BlockLists.POWER_NOT_DOOR).getItemBlock();



    static {
        Class clazz = ItemLists.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Object obj = null;
            try {
                obj = field.get(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (obj instanceof Item) {
                ItemList.add((Item) obj);
            }
        }
    }
}
