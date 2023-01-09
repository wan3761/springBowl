package com.wan.minecraft.springBowel.listener;


import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.block.BlockLists;
import com.wan.minecraft.springBowel.proxy.IWanBlock;
import com.wan.minecraft.springBowel.proxy.IHasATileEntity;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.Sys;

//@Mod.EventBusSubscriber(modid = WanMod.MODID)
public class BlockRegister {
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        BlockLists blockLists = new BlockLists();
        for (Block block : BlockLists.allItems()) {
            WanMod.logger.info(block.getRegistryName());
            if (block instanceof IWanBlock) {
                ((IWanBlock) block).registryMyself(event);
            } else {
                event.getRegistry().register(block);
            }
            if (block instanceof IHasATileEntity) {
                ((IHasATileEntity) block).registryTileEntity();
            }

        }
    }
}
