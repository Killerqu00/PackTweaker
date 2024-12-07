package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.PackTweaker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SoulboundEvent {

    //packtweaker:soulbound item tag to make items soulbound
    public static final TagKey<Item> IS_SOULBOUND = ItemTags.create(new ResourceLocation(PackTweaker.MODID, "soulbound"));

    //This prevents the soulbound item from showing up on the corpse and readds it to the inventory
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onInvDrop(LivingDropsEvent event){
        if(!(event.getEntity() instanceof ServerPlayer player)) return; //Don't do anything if it's not a player
        event.getDrops().removeIf(e -> e.getItem().is(IS_SOULBOUND) && player.getInventory().add(e.getItem()));
    }

    //Without this, the soulbound items just...disappear.
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getEntity().getInventory().replaceWith(event.getOriginal().getInventory());
    }

}
