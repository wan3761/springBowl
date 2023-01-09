package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.block.AndDoor;
import com.wan.minecraft.springBowel.block.BlockLists;
import com.wan.minecraft.springBowel.block.OrDoor;
import com.wan.minecraft.springBowel.block.XorDoor;
import com.wan.minecraft.springBowel.proxy.ReflexUtil;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ItemLists {
    public static final HashMap<Class, Item> ItemList = new HashMap<>();
    public static final HashMap<String, Item> ItemListByString = new HashMap<>();

    public static final ItemBlock               AND_DOOR    = ((AndDoor)BlockLists.BlockList.get(AndDoor.class)).getItemBlock();
    public static final ItemBlock               OR_DOOR     = ((OrDoor)BlockLists.BlockList.get(OrDoor.class)).getItemBlock();
    //TODO 以下物品的模型
    public static final ItemBlock               XOR_DOOR    = ((XorDoor)BlockLists.BlockList.get(XorDoor.class)).getItemBlock();
    public static final NotDoor                 NOT_DOOR    = ((com.wan.minecraft.springBowel.block.NotDoor)BlockLists.BlockList.get(com.wan.minecraft.springBowel.block.NotDoor.class)).getItemBlock();

    public static Item get(Class clazz) {
        return ItemList.get(clazz);
    }

    public static Item get(String clazz) {
        return ItemListByString.get(clazz);
    }

    static {
        {
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
                    ItemListByString.put(field.getName(), (Item) obj);
                }
            }
        }




        Set<Class<?>> classes = null;
        try {
            classes = ReflexUtil.getClasses("com.wan.minecraft.springBowel.item");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Class clazz : classes){
            Annotation[] annotations = clazz.getAnnotations();
            if (clazz.isAssignableFrom(Item.class)){
                continue;
            }
            for (Annotation annotation : annotations){
                if (annotation.annotationType().equals(WanModItem.class)){
                    try {
                        if (!((WanModItem)annotation).value() && !Arrays.equals(((WanModItem) annotation).stringKey(), new String[]{})){
                            for (String string : ((WanModItem)annotation).stringKey()){
                                ItemListByString.put(string, (Item) clazz.getDeclaredConstructor().newInstance());
                            }
                        }
                        if (((WanModItem)annotation).value()){
                            Item block = (Item) clazz.getDeclaredConstructor().newInstance();
                            ItemList.put(clazz, block);
                        }
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException | NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static List<Item> allItems(){
        List<Item> list = new ArrayList<>();
        for (Class c : ItemList.keySet()){
            list.add(ItemList.get(c));
        }
        for (String c : ItemListByString.keySet()){
            list.add(ItemListByString.get(c));
        }
        return list;
    }
}
