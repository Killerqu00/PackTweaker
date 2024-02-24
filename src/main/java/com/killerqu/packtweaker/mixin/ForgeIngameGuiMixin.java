package com.killerqu.packtweaker.mixin;

import com.killerqu.packtweaker.config.CommonConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ForgeGui.class, remap = false)
public class ForgeIngameGuiMixin {
    @Inject(method = "renderFood", at = @At("HEAD"), cancellable = true)
    public void packtweaker$renderHunger(int width, int height, PoseStack poseStack, CallbackInfo ci) {
        if (!CommonConfig.ENABLE_HUNGER.get()) {
            ci.cancel();
        }
    }
}
