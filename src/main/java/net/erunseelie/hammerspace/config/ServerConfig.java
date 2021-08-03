package net.erunseelie.hammerspace.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {

    private final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    private final ForgeConfigSpec spec;

    public ServerConfig() {
        spec = builder.build();
    }

    public ForgeConfigSpec getSpec() {
        return spec;
    }

}
