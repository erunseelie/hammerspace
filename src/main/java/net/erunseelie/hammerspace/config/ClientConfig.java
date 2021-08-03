package net.erunseelie.hammerspace.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {

    private final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    private final ForgeConfigSpec spec;

    public ClientConfig() {
        spec = builder.build();
    }

    public ForgeConfigSpec getSpec() {
        return spec;
    }

}
