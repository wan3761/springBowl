package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.WanModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@WanModBlock
public class OrDoor extends BlockRedStoneDoorBase {
    protected OrDoor(boolean powered) {
        super(powered);
    }

    public OrDoor(){
        super(false);
        this.setRegistryName(WanMod.MODID, "power_or_door_block").setUnlocalizedName("spring_bowel.or_item");
    }

    @Override

    protected IBlockState getPoweredState(IBlockState unpoweredState) {
        EnumFacing facing = unpoweredState.getValue(FACING);
        boolean bool = unpoweredState.getValue(POWERED);
        return BlockLists.get(this.getClass()).getDefaultState().withProperty(FACING, facing).withProperty(POWERED, bool);
    }

    @Override
    protected IBlockState getUnpoweredState(IBlockState poweredState) {
        EnumFacing facing = poweredState.getValue(FACING);
        boolean bool = poweredState.getValue(POWERED);
        return BlockLists.get(this.getClass()).getDefaultState().withProperty(FACING, facing).withProperty(POWERED, bool);
    }

    @Override
    public boolean getOutStatus(boolean a, boolean b) {
        return a || b;
    }
}
