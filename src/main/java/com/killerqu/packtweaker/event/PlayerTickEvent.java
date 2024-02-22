package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.config.CommonConfig;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerTickEvent {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (!CommonConfig.ENABLE_HUNGER.get()) {
            event.player.getFoodData().setFoodLevel(CommonConfig.CONSTANT_HUNGER_VALUE.get());
            event.player.getFoodData().setSaturation(20);
        }
    }
}
