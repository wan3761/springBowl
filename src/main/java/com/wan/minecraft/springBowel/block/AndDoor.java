package com.wan.minecraft.springBowel.block;

import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.state.IBlockState;

public class AndDoor extends BlockRedstoneDiode {
    protected AndDoor(boolean powered) {
        super(powered);
    }

    @Override
    protected int getDelay(IBlockState state) {
        return 0;
    }

    @Override
    protected IBlockState getPoweredState(IBlockState unpoweredState) {
        return null;
    }

    @Override
    protected IBlockState getUnpoweredState(IBlockState poweredState) {
        return null;
    }
}
