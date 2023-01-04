package com.wan.minecraft.springBowel.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

public class XorDoor extends BlockRedStoneDoorBase{
    protected XorDoor(boolean powered) {
        super(powered);
    }

    @Override
    protected IBlockState getPoweredState(IBlockState unpoweredState) {
        EnumFacing facing = unpoweredState.getValue(FACING);
        boolean bool = unpoweredState.getValue(POWERED);
        return BlockLists.POWER_XOR_DOOR.getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    @Override
    protected IBlockState getUnpoweredState(IBlockState poweredState) {
        EnumFacing facing = poweredState.getValue(FACING);
        boolean bool = poweredState.getValue(POWERED);
        return BlockLists.POWER_XOR_DOOR.getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    @Override
    public boolean getOutStatus(boolean a, boolean b) {
        return a != b;
    }
}
