package com.wan.minecraft.springBowel.potion;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PotionLists {
    public static final List<PotionBase> PotionList = new ArrayList<>();
    public static final Deaf deaf = new Deaf(true, 1328401);
    public static final Nonsense NONSENSE = new Nonsense(true, 1328401);
    public static final QuicklyHit quicklyHit = new QuicklyHit(false, 1328401);
    public static final Silent silent = new Silent();

    static {
        Class clazz = PotionLists.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Object obj = null;
            try {
                obj = field.get(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (obj instanceof PotionBase) {
                PotionList.add((PotionBase) obj);
            }
        }
    }
}
