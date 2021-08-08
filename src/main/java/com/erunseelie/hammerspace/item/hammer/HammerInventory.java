package com.erunseelie.hammerspace.item.hammer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;

public class HammerInventory extends Inventory {

    public HammerInventory(int rows) {
        super(rows * 9);
    }

    @Override
    public void openInventory(PlayerEntity player) {
        this.clear();
        ItemStack hammer = player.getHeldItemMainhand();
        if (hammer.isEmpty()) {
            CompoundNBT nbt = hammer.getTag();
            if (nbt != null && nbt.contains("Items", Constants.NBT.TAG_LIST)) {
                loadAllItems(nbt.getList("Items", Constants.NBT.TAG_COMPOUND), this);
            }
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        ItemStack hammer = player.getHeldItemMainhand();
        if (!hammer.isEmpty()) {
            CompoundNBT nbt = hammer.getTag();
            if (nbt == null) {
                nbt = new CompoundNBT();
            }
            ListNBT list = new ListNBT();
            saveAllItems(list, this);
            nbt.put("Items", list);
            hammer.setTag(nbt);
        }
    }


    public static void loadAllItems(ListNBT list, Inventory inventory) {
        for (int i = 0; i < list.size(); i++) {
            CompoundNBT nbt = list.getCompound(i);
            int slot = nbt.getByte("Slot") & 255;
            if (slot < inventory.getSizeInventory()) {
                inventory.setInventorySlotContents(slot, ItemStack.read(nbt));
            }
        }
    }

    public static ListNBT saveAllItems(ListNBT list, Inventory inventory) {
        for (int i = 0; i < inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = inventory.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                CompoundNBT nbt = new CompoundNBT();
                nbt.putByte("Slot", (byte) i);
                itemstack.write(nbt);
                list.add(nbt);
            }
        }
        return list;
    }

}
