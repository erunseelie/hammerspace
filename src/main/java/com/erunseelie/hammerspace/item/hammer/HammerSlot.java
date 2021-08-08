package com.erunseelie.hammerspace.item.hammer;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class HammerSlot extends Slot {

    public HammerSlot(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        // TODO add banned items, e.g. other containers etc.
        return true;
    }


}
