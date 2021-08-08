package com.erunseelie.hammerspace.init;

import com.erunseelie.hammerspace.Hammerspace;
import com.erunseelie.hammerspace.item.hammer.HammerContainer;
import com.erunseelie.hammerspace.item.hammer.HammerItem;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryItems {

    public static final DeferredRegister<Item> DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.ITEMS, Hammerspace.MOD_ID);

    public static final RegistryObject<Item> HAMMER =
            DEFERRED_REGISTER.register("hammer", HammerItem::new);

}
