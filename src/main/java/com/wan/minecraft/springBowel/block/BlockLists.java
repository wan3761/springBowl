package com.wan.minecraft.springBowel.block;

import net.minecraft.block.Block;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BlockLists {
    public static final List<Block> BlockList = new ArrayList<>();

    public static final KingHat kingHat = new KingHat();

    static {
        Class clazz = BlockLists.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Object obj = null;
            try {
                obj = field.get(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (obj instanceof Block) {
                BlockList.add((Block) obj);
            }
        }
    }
}
