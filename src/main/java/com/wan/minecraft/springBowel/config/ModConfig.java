package com.wan.minecraft.springBowel.config;

import com.wan.minecraft.springBowel.WanMod;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = WanMod.MODID)
@Config(modid = WanMod.MODID)
@Config.LangKey("config.spring_bowel.general")
public final class ModConfig {

    @Config.Comment("非门的延迟")
    @Config.LangKey("config.spring_bowel.general.not_gate_delay")
    @Config.Name("not gate delay")
    @Config.RangeInt(min = 1, max = 20)
    public static int notGateHasDelay = 0;

    @Config.Comment("Creeper的威力")
    @Config.LangKey("config.spring_bowel.general.creeper_strength")
    @Config.Name("creep strength")
    @Config.RangeInt(min = 1, max = 20)
    public static float creepStrength;


    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(WanMod.MODID)) {
            ConfigManager.sync(WanMod.MODID, Config.Type.INSTANCE);
        }
    }
}
