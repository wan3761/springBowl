package com.wan.minecraft.springBowel;

import com.wan.minecraft.springBowel.tab.SpringBowl;
import com.wan.minecraft.springBowel.tab.SpringBowlFace;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = WanMod.MODID, name = WanMod.NAME, version = WanMod.VERSION)
public class WanMod {

    public static final SpringBowl springBowl = new SpringBowl("Spring_Bowl");
    public static final SpringBowlFace springBowlFace = new SpringBowlFace("Spring_Bowl_Face");

    public static final String MODID = "spring_bowel";
    public static final String NAME = "Happy New Year";
    public static final String VERSION = "2.5.1";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }


    @EventHandler
    public void postLoad(FMLPostInitializationEvent event) {

    }
}
