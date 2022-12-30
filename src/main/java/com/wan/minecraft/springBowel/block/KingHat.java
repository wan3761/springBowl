package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.item.ItemLists;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class KingHat extends Block {

    public KingHat(MapColor blockMapColorIn) {
        super(Material.IRON, blockMapColorIn);
        this.setRegistryName(WanMod.MODID, "king_hat_block");
        this.setCreativeTab(WanMod.springBowl);
    }

    public KingHat() {
        super(Material.IRON);
        this.setRegistryName(WanMod.MODID, "king_hat_block");
        this.setCreativeTab(WanMod.springBowl);
        this.setHardness(1.5f);
    }


    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.add(new ItemStack(ItemLists.kingHat));
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

}
