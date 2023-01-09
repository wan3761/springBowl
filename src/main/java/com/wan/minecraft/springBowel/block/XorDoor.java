package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.WanModBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

@WanModBlock
public class XorDoor extends BlockRedStoneDoorBase{
    protected XorDoor(boolean powered) {
        super(powered);
    }

    public XorDoor(){
        super(false);
        this.setRegistryName(WanMod.MODID, "power_xor_door_block").setUnlocalizedName("spring_bowel.xor_door_item");
    }

    @Override
    protected IBlockState getPoweredState(IBlockState unpoweredState) {
        EnumFacing facing = unpoweredState.getValue(FACING);
        boolean bool = unpoweredState.getValue(POWERED);
        return BlockLists.get(this.getClass()).getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    @Override
    protected IBlockState getUnpoweredState(IBlockState poweredState) {
        EnumFacing facing = poweredState.getValue(FACING);
        boolean bool = poweredState.getValue(POWERED);
        return BlockLists.get(this.getClass()).getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    @Override
    public boolean getOutStatus(boolean a, boolean b) {
        return a != b;
    }
}
