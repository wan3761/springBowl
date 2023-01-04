package com.wan.minecraft.springBowel.item;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class NotDoor extends WanModItemBlockBase {
    public NotDoor(Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("请不要短接非门的输入端与输出端，否则可能出现未知错误（该问题可能在未来版本得到解决）");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
