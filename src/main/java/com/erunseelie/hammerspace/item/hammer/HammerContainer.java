package com.erunseelie.hammerspace.item.hammer;

import com.erunseelie.hammerspace.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;

public class HammerContainer extends Container {

    private final IInventory hammerInventory;
    private final int rows;

//    public static HammerContainer fromBuffer(int windowId, PlayerInventory inventory, PacketBuffer buffer) {
//        return new HammerContainer(windowId, inventory.player, HammerContext.fromBuffer(buffer));
//    }

    public HammerContainer(int id, PlayerInventory playerInventory, int rows) {
        this(id, playerInventory, new Inventory(9 * rows), rows);
    }

    public HammerContainer(int id, PlayerInventory playerInventory, IInventory hammerInventory, int rows) {
        super(ModContainers.HAMMER.get(), id);
        assertInventorySize(hammerInventory, rows * 9);
        this.hammerInventory = hammerInventory;
        this.rows = rows;

        hammerInventory.openInventory(playerInventory.player);

        // GUI math...
        int offset = (this.rows - 4) * 18;

        // sets up the custom container GUI.
        // populates the container with slots equal to this.rows * 9.
        for (int i = 0; i < this.rows; i++) {
            for (int ii = 0; ii < 9; ii++) {  // ++ii?
                this.addSlot(new HammerSlot(
                        hammerInventory,
                        i + ii * 9,
                        8 + i * 18,
                        18 + ii * 18
                ));
            }
        }

        // sets up the standard player inventory (minus hotbar).
        // TODO maybe extract for reuse?
        for (int i = 0; i < 3; i++) {
            for (int ii = 0; ii < 9; ii++) {
                this.addSlot(new Slot(
                        playerInventory,
                        ii + i * 9 + 9,
                        8 + ii * 18,
                        103 + i * 18 + offset
                ));
            }
        }

        // sets up the standard player hotbar.
        // TODO maybe extract for reuse?
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(
                    playerInventory,
                    i,
                    8 + i * 18,
                    161 + offset
            ));
        }

    }

    @Override
    public boolean canInteractWith(PlayerEntity player) {
        return this.hammerInventory.isUsableByPlayer(player);
    }

    @Override
    public void onContainerClosed(PlayerEntity player) {
        super.onContainerClosed(player);
        this.hammerInventory.closeInventory(player);
    }

    public int getRows() {
        return this.rows;
    }

}
