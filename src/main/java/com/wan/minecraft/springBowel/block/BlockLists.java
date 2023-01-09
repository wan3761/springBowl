package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAItemBLock;
import com.wan.minecraft.springBowel.proxy.IWanBlock;
import com.wan.minecraft.springBowel.proxy.ReflexUtil;
import com.wan.minecraft.springBowel.proxy.WanModBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import scala.reflect.internal.Trees;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BlockLists {
    public static final HashMap<Class, Block> BlockList = new HashMap<>();
    public static final HashMap<String, Block> BlockListByString = new HashMap<>();

    public static Block get(Class clazz) {
        return BlockList.get(clazz);
    }

    public static Block get(String clazz) {
        return BlockListByString.get(clazz);
    }

    static {
        Set<Class<?>> classes = null;
        try {
            classes = ReflexUtil.getClasses("com.wan.minecraft.springBowel.block");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Class clazz : classes){
            Annotation[] annotations = clazz.getAnnotations();
            if (clazz.isAssignableFrom(Block.class)){
                continue;
            }
            for (Annotation annotation : annotations){
                if (annotation.annotationType().equals(WanModBlock.class)){
                    try {
                        if (!((WanModBlock)annotation).value() && !Arrays.equals(((WanModBlock) annotation).stringKey(), new String[]{})){
                            for (String string : ((WanModBlock)annotation).stringKey()){
                                BlockListByString.put(string, (Block) clazz.getDeclaredConstructor().newInstance());
                            }
                        }
                        if (((WanModBlock)annotation).value()){
                            Block block = (Block) clazz.getDeclaredConstructor().newInstance();
                            if (block instanceof IHasAItemBLock){
                                ((IHasAItemBLock) block).createItemBlock();
                            }
                            BlockList.put(clazz, block);
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
    public static List<Block> allItems(){
        List<Block> list = new ArrayList<>();
        for (Class c : BlockList.keySet()){
            list.add(BlockList.get(c));
        }
        for (String c : BlockListByString.keySet()){
            list.add(BlockListByString.get(c));
        }
        return list;
    }
}
