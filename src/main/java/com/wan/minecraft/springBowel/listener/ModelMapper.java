package com.wan.minecraft.springBowel.listener;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.proxy.IHasAItemBLock;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = WanMod.MODID)
public class ModelMapper {
    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {
        OBJLoader.INSTANCE.addDomain(WanMod.MODID);
        for (Item item : ItemLists.ItemList) {
            if (item instanceof IHasAModel){
                ((IHasAModel) item).registryModel(event);
            }else {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            }
        }
    }
}
