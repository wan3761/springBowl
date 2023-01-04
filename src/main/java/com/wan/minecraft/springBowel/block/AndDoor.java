package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.proxy.IHasAItemBLock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;

public class AndDoor extends BlockRedStoneDoorBase{


    protected AndDoor(boolean powered) {
        super(powered);
    }

    @Override
    public boolean getOutStatus(boolean a, boolean b) {
        return a & b;
    }

    @Override
    protected IBlockState getPoweredState(IBlockState unpoweredState) {
        EnumFacing facing = unpoweredState.getValue(FACING);
        boolean bool = unpoweredState.getValue(POWERED);
        return BlockLists.POWER_AND_DOOR.getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    @Override
    protected IBlockState getUnpoweredState(IBlockState poweredState) {
        EnumFacing facing = poweredState.getValue(FACING);
        boolean bool = poweredState.getValue(POWERED);
        return BlockLists.POWER_AND_DOOR.getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }


}
