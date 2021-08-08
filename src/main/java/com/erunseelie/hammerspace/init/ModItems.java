package com.erunseelie.hammerspace.init;

import com.erunseelie.hammerspace.Hammerspace;
import com.erunseelie.hammerspace.item.ModItem;
import com.erunseelie.hammerspace.item.hammer.HammerContainer;
import com.erunseelie.hammerspace.item.hammer.HammerItem;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Hammerspace.MOD_ID)
public class ModItems {

    private ModItems() {
    }


    public static HammerItem hammerItem = new HammerItem();
//
//    @ObjectHolder("hammerspace")
//    public static HammerContainer hammerContainer;


    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(hammerItem.setRegistryName(Hammerspace.MOD_ID, "hammer"));

    }


//    private static final DeferredRegister<Item> ITEMS =
//            DeferredRegister.create(ForgeRegistries.ITEMS, Hammerspace.MOD_ID);
//
//    private static final DeferredRegister<ContainerType<?>> CONTAINERS =
//            DeferredRegister.create(ForgeRegistries.CONTAINERS, Hammerspace.MOD_ID);
//
//
//    public static final RegistryObject<HammerItem> HAMMER =
//            ITEMS.register("hammer", () -> new HammerItem(null));
//
//
//    public static final RegistryObject<ContainerType<HammerContainer>> HAMMER_CONTAINER =
//            CONTAINERS.register("settings",
//                    () -> IForgeContainerType.create(HammerContainer::fromBuffer));
//
//
//    public static void registerHandlers(IEventBus modBus) {
//        ITEMS.register(modBus);
//        CONTAINERS.register(modBus);


}
