package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasATileEntity;
import com.wan.minecraft.springBowel.proxy.WanModBlock;
import com.wan.minecraft.springBowel.tileEntity.TileEntityLocker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

@WanModBlock
public class Locker extends BlockContainer implements IHasATileEntity {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool OPENED = PropertyBool.create("opened");

    public Locker(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public Locker(Material materialIn) {
        super(materialIn);
    }

    public Locker(){
        super(Material.IRON);
        this.hasTileEntity=true;
        this.setRegistryName(WanMod.MODID, "locker_block").setUnlocalizedName("spring_bowel.locker").setCreativeTab(WanMod.springBowl);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING,EnumFacing.NORTH).withProperty(OPENED,false));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,FACING,OPENED);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityLocker();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int facing = state.getValue(FACING).getHorizontalIndex();
        int powered = state.getValue(OPENED) ? 0b0100 : 0;
        return facing | powered;
    }

    private boolean isOcelotSittingOnChest(World worldIn, BlockPos pos)
    {
        for (Entity entity : worldIn.getEntitiesWithinAABB(EntityOcelot.class, new AxisAlignedBB((double)pos.getX(), (double)(pos.getY() + 1), (double)pos.getZ(), (double)(pos.getX() + 1), (double)(pos.getY() + 2), (double)(pos.getZ() + 1))))
        {
            EntityOcelot entityocelot = (EntityOcelot)entity;

            if (entityocelot.isSitting())
            {
                return true;
            }
        }

        return false;
    }

    private boolean isBelowSolidBlock(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.up()).doesSideBlockChestOpening(worldIn, pos.up(), EnumFacing.DOWN);
    }

    @Nullable
    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
    {
        return this.getContainer(worldIn, pos, false);
    }

    private boolean isBlocked(World worldIn, BlockPos pos)
    {
        return this.isBelowSolidBlock(worldIn, pos) || this.isOcelotSittingOnChest(worldIn, pos);
    }

    @Nullable
    public ILockableContainer getContainer(World worldIn, BlockPos pos, boolean allowBlocking)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        {
            ILockableContainer ilockablecontainer = (TileEntityLocker)tileentity;

            if (!allowBlocking && this.isBlocked(worldIn, pos))
            {
                return null;
            }
            else
            {
                for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
                {
                    BlockPos blockpos = pos.offset(enumfacing);
                    Block block = worldIn.getBlockState(blockpos).getBlock();

                    if (block == this)
                    {
                        if (!allowBlocking && this.isBlocked(worldIn, blockpos)) // Forge: fix MC-99321
                        {
                            return null;
                        }

                        TileEntity tileentity1 = worldIn.getTileEntity(blockpos);

                        if (tileentity1 instanceof TileEntityChest)
                        {
                            if (enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH)
                            {
                                ilockablecontainer = new InventoryLargeChest("container.chestDouble", ilockablecontainer, (TileEntityChest)tileentity1);
                            }
                            else
                            {
                                ilockablecontainer = new InventoryLargeChest("container.chestDouble", (TileEntityChest)tileentity1, ilockablecontainer);
                            }
                        }
                    }
                }

                return ilockablecontainer;
            }
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            ILockableContainer ilockablecontainer = this.getLockableContainer(worldIn, pos);

            String pwd = playerIn.getHeldItem(EnumHand.MAIN_HAND).getDisplayName();
            TileEntityLocker tileEntityLocker = (TileEntityLocker) worldIn.getTileEntity(pos);

            if (!tileEntityLocker.getPassword().equals("0")){
                if(!pwd.equals(tileEntityLocker.getPassword())){
                    return false;
                }
            }

            

            if (ilockablecontainer != null)
            {
                playerIn.displayGUIChest(ilockablecontainer);


                    //playerIn.addStat(StatList.CHEST_OPENED);

            }

            return true;
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getHorizontal(meta & 0b0011);
        boolean powered = (meta & 0b0100) != 0;
        return this.getDefaultState().withProperty(FACING, facing).withProperty(OPENED, powered);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void registryTileEntity() {
        GameRegistry.registerTileEntity(TileEntityLocker.class,new ResourceLocation(WanMod.MODID,"locker_block"));
    }
}
