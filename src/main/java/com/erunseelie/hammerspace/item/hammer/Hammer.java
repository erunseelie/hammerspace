package com.erunseelie.hammerspace.item.hammer;

import com.erunseelie.hammerspace.ModItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class Hammer extends ModItem {

    public Hammer(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack item = player.getHeldItem(hand);
        // only operate for logical server
        if (world.isRemote && player instanceof ServerPlayerEntity) {
            showInventory((ServerPlayerEntity) player);
            return ActionResult.resultSuccess(item);
        }
        return ActionResult.resultFail(item);
    }

    public void showInventory(ServerPlayerEntity player) {
        // TODO open GUI, show linked container inventory, etc.

        // TODO get better display name
        // https://github.com/MrCrayfish/Backpacked/blob/dc3c75d485f2222ce7fa789398654546a35771e8/src/main/java/com/mrcrayfish/backpacked/item/BackpackItem.java#L77
        ITextComponent title = new TranslationTextComponent("hammerspace.container");
        int rows = this.getRowCount();
        NetworkHooks.openGui(
                player,
                new SimpleNamedContainerProvider(
                        (id, playerInventory, entity) ->
                                new HammerContainer(
                                        id,
                                        player.inventory,
                                        new HammerInventory(rows),
                                        rows),
                        title),
                buffer -> buffer.writeVarInt(rows)
        );
    }

    public int getRowCount() {
//        TODO read in from config values
//        https://github.com/MrCrayfish/Backpacked/blob/dc3c75d485f2222ce7fa789398654546a35771e8/src/main/java/com/mrcrayfish/backpacked/item/BackpackItem.java#L87

        return 4;

    }

}
