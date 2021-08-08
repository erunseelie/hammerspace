package com.erunseelie.hammerspace.item.hammer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class HammerInventory extends Inventory {

    public HammerInventory(int rows) {
        super (rows * 9);
    }

    @Override
    public void openInventory(PlayerEntity player) {
        this.clear();
//        TODO
//        ItemStack hammer =
    }

}
