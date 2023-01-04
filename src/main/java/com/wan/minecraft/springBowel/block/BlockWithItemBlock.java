package com.wan.minecraft.springBowel.block;

import com.wan.minecraft.springBowel.proxy.IHasAItemBLock;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public abstract class BlockWithItemBlock extends WanModBlockBase implements IHasAItemBLock {
    private final ItemBlock itemBlock = (ItemBlock) new ItemBlock(this).setRegistryName(this.getRegistryName().toString()).setUnlocalizedName(this.getUnlocalizedName());

    @Override
    public ItemBlock getItemBlock() {
        return itemBlock;
    }

    public BlockWithItemBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public BlockWithItemBlock(Material materialIn) {
        super(materialIn);
    }
}
