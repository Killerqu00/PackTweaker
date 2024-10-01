package com.killerqu.packtweaker.mixin;

import com.killerqu.packtweaker.config.ClientConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.screens.PauseScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PauseScreen.class)
public class PauseScreenMixin {
    //NOTE: Intellij might complain, DO NOT give it attention. These are working as intended.

    //Replaces the "Report Bugs" url.
    @ModifyExpressionValue(method = "*", at = @At(value = "CONSTANT", args = "stringValue=https://aka.ms/snapshotbugs?ref=game"))
    private String modifyBugUrl(String original) {
        return ClientConfig.BUG_REPORT_URL.get();
    }

    //Replaces the "Give Feedback" url.
    @ModifyExpressionValue(method = "*", at = @At(value = "CONSTANT", args = "stringValue=https://aka.ms/javafeedback?ref=game"))
    private String modifyFeedbackUrl(String original) {
        return ClientConfig.FEEDBACK_URL.get();
    }

}
