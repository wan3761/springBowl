package com.wan.minecraft.springBowel.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//TODO 修复以下类在输入和输出端被连接时的死递归bug
public class NotDoor extends BlockRedStoneDoorBase {
    protected NotDoor(boolean powered) {
        super(powered);
    }

    private final com.wan.minecraft.springBowel.item.NotDoor itemBlock = (com.wan.minecraft.springBowel.item.NotDoor) new com.wan.minecraft.springBowel.item.NotDoor(this).setRegistryName(this.getRegistryName().toString()).setUnlocalizedName(this.getUnlocalizedName());

    @Override
    public com.wan.minecraft.springBowel.item.NotDoor getItemBlock() {
        return itemBlock;
    }

    private boolean shouldBeLock;

    public boolean isShouldBeLock() {
        return shouldBeLock;
    }

    @Override
    protected IBlockState getPoweredState(IBlockState unpoweredState) {
        EnumFacing facing = unpoweredState.getValue(FACING);
        boolean bool = unpoweredState.getValue(POWERED);
        return BlockLists.POWER_NOT_DOOR.getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    @Override
    protected IBlockState getUnpoweredState(IBlockState poweredState) {
        EnumFacing facing = poweredState.getValue(FACING);
        boolean bool = poweredState.getValue(POWERED);
        return BlockLists.POWER_NOT_DOOR.getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    @Override
    public boolean getOutStatus(boolean a, boolean b) {
        return !a;
    }

    @Override
    protected boolean shouldBePowered(World worldIn, BlockPos pos, IBlockState state) {
        int a = calculateInputStrength(worldIn,pos,state);

        if (getOutStatus(a > 0,true)){
            worldIn.setBlockState(pos,state.withProperty(POWERED,true));
            return true;
        }else {
            worldIn.setBlockState(pos,state.withProperty(POWERED,false));
            return false;
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        IBlockState state1 = worldIn.getBlockState(pos.offset(state.getValue(FACING).getOpposite()));

        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
    }

}