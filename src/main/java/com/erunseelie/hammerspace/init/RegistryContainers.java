package com.erunseelie.hammerspace.init;

import com.erunseelie.hammerspace.Hammerspace;
import com.erunseelie.hammerspace.item.hammer.HammerContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryContainers {

    public static final DeferredRegister<ContainerType<?>> DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, Hammerspace.MOD_ID);

    private static <T extends Container> RegistryObject<ContainerType<T>>
    register(String id, ContainerType.IFactory<T> factory) {
        return DEFERRED_REGISTER.register(id, () -> new ContainerType<>(factory));
    }

    public static final RegistryObject<ContainerType<HammerContainer>> HAMMER =
            register("hammer", (IContainerFactory<HammerContainer>) (windowId, playerInventory, data) ->
                    new HammerContainer(windowId, playerInventory, data.readVarInt()));

}
