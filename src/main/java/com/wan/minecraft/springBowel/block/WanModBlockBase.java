package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.proxy.IWanBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public abstract class WanModBlockBase extends Block implements IWanBlock {
    public WanModBlockBase(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public WanModBlockBase(Material materialIn) {
        super(materialIn);
    }
}
