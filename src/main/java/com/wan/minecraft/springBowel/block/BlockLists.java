package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraft.block.Block;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BlockLists {
    public static final List<Block> BlockList = new ArrayList<>();

    public static final WanModBlockBase         kingHat            = new KingHat();
    public static final BlockRedStoneDoorBase   POWER_AND_DOOR     = (AndDoor) new AndDoor(true).setRegistryName(WanMod.MODID, "power_and_door_block").setUnlocalizedName("spring_bowel.and_door_item");
    public static final BlockRedStoneDoorBase   POWER_OR_DOOR      = (OrDoor) new OrDoor(true).setRegistryName(WanMod.MODID, "power_or_door_block").setUnlocalizedName("spring_bowel.or_item");
    public static final BlockRedStoneDoorBase   POWER_XOR_DOOR     = (XorDoor) new XorDoor(true).setRegistryName(WanMod.MODID, "power_xor_door_block").setUnlocalizedName("spring_bowel.xor_door_item");
    public static final BlockRedStoneDoorBase   POWER_NOT_DOOR     = (NotDoor) new NotDoor(true).setRegistryName(WanMod.MODID, "power_not_door_block").setUnlocalizedName("spring_bowel.not_door_item");

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
