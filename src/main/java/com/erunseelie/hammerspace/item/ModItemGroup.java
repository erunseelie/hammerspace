package com.erunseelie.hammerspace.item;

import com.erunseelie.hammerspace.Hammerspace;
import com.erunseelie.hammerspace.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ModItemGroup extends ItemGroup {

    private ItemStack icon;

    public ModItemGroup() {
        super(Hammerspace.MOD_ID);
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        if (icon == null) {
            // TODO set icon to specific item
            // https://github.com/P3pp3rF1y/SophisticatedBackpacks/blob/774d848394b7cb4f2ec6f116f3bb075c6bdaa98d/src/main/java/net/p3pp3rf1y/sophisticatedbackpacks/SBItemGroup.java#L17
            icon = new ItemStack(ModItems.hammerItem.getItem());

        }
        return icon;
    }
}
