package com.erunseelie.hammerspace.item;

import com.erunseelie.hammerspace.ModItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Hammer extends ModItem {

    public Hammer(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (!world.isRemote && player instanceof ServerPlayerEntity) {
        }


        return ActionResult.resultSuccess(stack);
    }
}
