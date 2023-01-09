package com.wan.minecraft.springBowel.event;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.ItemLists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = WanMod.MODID)
public class ModelMapper {
    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {
        OBJLoader.INSTANCE.addDomain(WanMod.MODID);
        for(Class clazz : ItemLists.ItemList.keySet()){
            Item item = ItemLists.get(clazz);
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
