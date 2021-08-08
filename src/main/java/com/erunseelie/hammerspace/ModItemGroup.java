package com.erunseelie.hammerspace;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ModItemGroup extends ItemGroup {

    private ItemStack icon;

    ModItemGroup() {
        super(Hammerspace.MOD_ID);
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        if (icon == null) {
            // TODO set icon to specific item
            // https://github.com/P3pp3rF1y/SophisticatedBackpacks/blob/774d848394b7cb4f2ec6f116f3bb075c6bdaa98d/src/main/java/net/p3pp3rf1y/sophisticatedbackpacks/SBItemGroup.java#L17
        }
        return icon;
    }
}
