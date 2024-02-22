package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.PackTweaker;
import com.killerqu.packtweaker.config.CommonConfig;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PackTweaker.MODID)
public class NetherPortalDisableEvent {
    @SubscribeEvent
    public static void onNetherPortalForm(BlockEvent.PortalSpawnEvent event) {
        event.setCanceled(!CommonConfig.ENABLE_NETHER_PORTALS.get());
    }
}
