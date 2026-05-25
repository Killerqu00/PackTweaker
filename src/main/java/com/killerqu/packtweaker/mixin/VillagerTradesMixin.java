package com.killerqu.packtweaker.mixin;

import com.killerqu.packtweaker.config.CommonConfig;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.trading.MerchantOffers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

//This mixin disables trading with a villagers by making it think it has no trades.
//It does not touch the actual trades list and is controlled by a config.
@Mixin(Villager.class)
public class VillagerTradesMixin {
    //This is the list that gets swapped in.
    @Unique
    private static MerchantOffers packTweaker$EMPTY = new MerchantOffers();

    @Redirect(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/npc/Villager;getOffers()Lnet/minecraft/world/item/trading/MerchantOffers;"))
    //MerchantOffers is a glorified ArrayList with extra functions for handling nbt. It has an isEmpty() method but remapping does NOT like it.
    //So we return a separate empty list, doing so does not overwrite existing trades so if trades are re-enabled everything will be intact.
    private MerchantOffers tradingCheck(Villager instance){
        if(!CommonConfig.ENABLE_TRADING.get()) return packTweaker$EMPTY;
        else return instance.getOffers();
    }
}
