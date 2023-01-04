package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAItemBLock;
import com.wan.minecraft.springBowel.proxy.IWanBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockRedStoneDoorBase extends BlockRedstoneDiode implements IWanBlock, IHasAItemBLock {
    public static final PropertyBool POWERED = PropertyBool.create("powered");

    protected ItemBlock itemBlock;

    @Override
    public ItemBlock getItemBlock() {
        return itemBlock;
    }
    private BlockRedStoneDoorBase power = null;
    private BlockRedStoneDoorBase unpower = null;

    @Override
    public Block createItemBlock() {
        this.itemBlock=(ItemBlock) new ItemBlock(this).setRegistryName(this.getRegistryName().toString()).setUnlocalizedName(this.getUnlocalizedName());
        return this;
    }

    protected BlockRedStoneDoorBase(boolean powered) {
        super(powered);
        this.setCreativeTab(WanMod.springBowl);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(POWERED,false));
    }

    public BlockRedStoneDoorBase setPower(BlockRedStoneDoorBase power){
        this.power=power;
        return this;
    }

    public BlockRedStoneDoorBase setUnpower(BlockRedStoneDoorBase unpower){
        this.unpower=unpower;
        return this;
    }


    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return FULL_BLOCK_AABB;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        AxisAlignedBB axisalignedbb = blockState.getBoundingBox(blockAccess, pos);

        switch (side)
        {
            case DOWN:

                if (axisalignedbb.minY > 0.0D)
                {
                    return true;
                }

                break;
            case UP:

                if (axisalignedbb.maxY < 1.0D)
                {
                    return true;
                }

                break;
            case NORTH:

                if (axisalignedbb.minZ > 0.0D)
                {
                    return true;
                }

                break;
            case SOUTH:

                if (axisalignedbb.maxZ < 1.0D)
                {
                    return true;
                }

                break;
            case WEST:

                if (axisalignedbb.minX > 0.0D)
                {
                    return true;
                }

                break;
            case EAST:

                if (axisalignedbb.maxX < 1.0D)
                {
                    return true;
                }
        }

        return !blockAccess.getBlockState(pos.offset(side)).doesSideBlockRendering(blockAccess, pos.offset(side), side.getOpposite());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,FACING,POWERED);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int facing = state.getValue(FACING).getHorizontalIndex();
        int powered = state.getValue(POWERED) ? 0b0100 : 0;
        return facing | powered;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getHorizontal(meta & 0b0011);
        boolean powered = (meta & 0b0100) != 0;
        return this.getDefaultState().withProperty(FACING, facing).withProperty(POWERED, powered);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return true;
    }

    @Override
    protected int getDelay(IBlockState state) {
        return 0;
    }

    protected boolean isPowered(IBlockState state)
    {
        return state.getValue(POWERED);
    }

    @Override
    protected IBlockState getPoweredState(IBlockState unpoweredState) {
        EnumFacing facing = unpoweredState.getValue(FACING);
        boolean bool = unpoweredState.getValue(POWERED);
        return this.power.getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    @Override
    protected IBlockState getUnpoweredState(IBlockState poweredState) {
        EnumFacing facing = poweredState.getValue(FACING);
        boolean bool = poweredState.getValue(POWERED);
        return this.power.getDefaultState().withProperty(FACING,facing).withProperty(POWERED,bool);
    }

    public abstract boolean getOutStatus(boolean a,boolean b);

    protected boolean shouldBePowered(World worldIn, BlockPos pos, IBlockState state){
        int a = calculateInputStrength(worldIn,pos,state);
        EnumFacing enumFacing = state.getValue(FACING);
        if (enumFacing.getHorizontalIndex()-1>=0) {
            enumFacing = EnumFacing.getHorizontal(enumFacing.getHorizontalIndex() - 1);
        }else{
            enumFacing = EnumFacing.EAST;
        }

        int b = calculateInputStrength(worldIn,pos,state.withProperty(FACING,enumFacing));
        if (getOutStatus(a > 0,b >0)){
            worldIn.setBlockState(pos,state.withProperty(POWERED,true));
            return true;
        }else {
            worldIn.setBlockState(pos,state.withProperty(POWERED,false));
            return false;
        }

    }

}
