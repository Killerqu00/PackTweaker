package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.config.CommonConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerTrySleepEvent {
    @SubscribeEvent
    public static void onSleepAttempt(PlayerSleepInBedEvent event) {
        if (!CommonConfig.ENABLE_SLEEP.get()) {
            event.getEntity().displayClientMessage(Component.literal("Sleeping is disabled!"), true);
            event.setResult(Player.BedSleepingProblem.OTHER_PROBLEM);
        }
    }
}
