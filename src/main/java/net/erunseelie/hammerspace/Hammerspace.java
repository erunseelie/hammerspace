package net.erunseelie.hammerspace;

import net.erunseelie.hammerspace.config.ClientConfig;
import net.erunseelie.hammerspace.config.ServerConfig;
import net.erunseelie.hammerspace.item.Hammer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = Hammerspace.MOD_ID)
@Mod.EventBusSubscriber(modid = Hammerspace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Hammerspace {

    public static final String MOD_ID = "hammerspace";
    private static final Logger LOGGER = LogManager.getLogger();

    public static final ServerConfig SERVER_CONFIG = new ServerConfig();
    public static final ClientConfig CLIENT_CONFIG = new ClientConfig();

    public static final ItemGroup ITEM_GROUP = new ItemGroup() {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Hammer.get());
        }
    }

    public Hammerspace() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG.getSpec());
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG.getSpec());
    }


    public static void init(final FMLCommonSetupEvent event) {

        // TODO
        event.enqueueWork(() -> {
        });
    }


}
