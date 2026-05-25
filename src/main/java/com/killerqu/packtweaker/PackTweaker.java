package com.killerqu.packtweaker;

import com.killerqu.packtweaker.config.ClientConfig;
import com.killerqu.packtweaker.config.CommonConfig;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.VillagerTradingManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
@Mod(PackTweaker.MODID)
public class PackTweaker {
    public static final String MODID = "packtweaker";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PackTweaker() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

    }
}
