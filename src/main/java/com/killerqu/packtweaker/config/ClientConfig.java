package com.killerqu.packtweaker.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<String> BUG_REPORT_URL;
    public static final ForgeConfigSpec.ConfigValue<String> FEEDBACK_URL;
    static {
        BUILDER.push("PackTweaker Client config");

        BUG_REPORT_URL = BUILDER.comment("Replaces the URL for the 'Report Bugs' button in the pause menu. Intended to point to a modpack's issue tracker.")
                .define("Issue Tracker URL", "https://aka.ms/snapshotbugs?ref=game");
        FEEDBACK_URL = BUILDER.comment("Replaces the URL for the 'Give Feedback' button. Intended to have a link to an user feedback form or a Discord invite.")
                .define("Feedback Page URL", "https://aka.ms/javafeedback?ref=game");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
