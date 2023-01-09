package com.wan.minecraft.springBowel.event;


import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.block.BlockLists;
import com.wan.minecraft.springBowel.proxy.IHasATileEntity;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = WanMod.MODID)
public class BlockRegister {
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event){

        for(Class clazz: BlockLists.BlockList.keySet()){
            Block block = BlockLists.get(clazz);
            event.getRegistry().register(block);

            if (block instanceof IHasATileEntity){
                ((IHasATileEntity) block).registryTileEntity();
            }
        }
    }
}
