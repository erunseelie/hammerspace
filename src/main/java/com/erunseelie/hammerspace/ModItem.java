package com.erunseelie.hammerspace;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ModItem extends Item {

    public ModItem(Properties properties){
        super(properties.group(Hammerspace.ITEM_GROUP));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
    }

}
