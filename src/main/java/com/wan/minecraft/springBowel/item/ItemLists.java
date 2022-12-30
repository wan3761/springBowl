package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.item.face.*;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ItemLists {
    public static final List<Item> ItemList = new ArrayList<>();

    public static final UselessThing uselessThing = new UselessThing();

    public static final Cyj cyj = new Cyj(1, true);
    public static final Cym cym = new Cym();
    public static final Djh djh = new Djh();
    public static final Ghq ghq = new Ghq();
    public static final Gyf gyf = new Gyf();
    public static final Lcs lcs = new Lcs();
    public static final Lcty lcty = new Lcty();
    public static final Lxh lxh = new Lxh();
    public static final Qxx qxx = new Qxx();
    public static final Wja wja = new Wja();
    public static final Yt yt = new Yt();
    public static final Yyd yyd = new Yyd();
    public static final Zjp zjp = new Zjp(1, 5, true);
    public static final Zip zip = new Zip();
    public static final Yj yj = new Yj(1, 5, true);
    public static final AnUsbDrive usb = new AnUsbDrive();
    public static final KingHatItemBlock kingHat = new KingHatItemBlock(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.HEAD);

    public static final DingDing ding = new DingDing();
    public static final Idea idea = new Idea();
    public static final Xshell xshell = new Xshell();
    public static final Forge forge = new Forge();
    public static final FireOpener fireOpener = new FireOpener();
    public static final GTX690 gtx690 = new GTX690();
    public static final Delta delta = new Delta();
    public static final GuaPi guaPi = new GuaPi();
    public static final Pirce pirce = new Pirce();
    public static final Silent silent = new Silent();

    //public static final ItemBlock kingHatItemBlock = (ItemBlock) new ItemBlock(BlockLists.kingHat).setRegistryName(WanMod.MODID,"king_hat_block");


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
