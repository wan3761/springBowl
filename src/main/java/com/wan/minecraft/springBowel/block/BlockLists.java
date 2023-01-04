package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAItemBLock;
import net.minecraft.block.Block;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BlockLists {
    public static final List<Block> BlockList = new ArrayList<>();

    public static final Block   kingHat            = new KingHat();
    public static final Block   POWER_AND_DOOR     = new AndDoor(true).setRegistryName(WanMod.MODID, "power_and_door_block").setUnlocalizedName("spring_bowel.and_door_item");
    public static final Block   POWER_OR_DOOR      = new OrDoor(true).setRegistryName(WanMod.MODID, "power_or_door_block").setUnlocalizedName("spring_bowel.or_item");
    public static final Block   POWER_XOR_DOOR     = new XorDoor(true).setRegistryName(WanMod.MODID, "power_xor_door_block").setUnlocalizedName("spring_bowel.xor_door_item");
    public static final Block   POWER_NOT_DOOR     = new NotDoor(true).setRegistryName(WanMod.MODID, "power_not_door_block").setUnlocalizedName("spring_bowel.not_door_item");

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
            System.out.println(field.getName());
            System.out.println(obj instanceof Block);
            if (obj instanceof Block) {
                BlockList.add((Block) obj);
                if (obj instanceof IHasAItemBLock){
                    ((IHasAItemBLock) obj).createItemBlock();
                }
            }
        }
    }
}
