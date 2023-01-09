package com.wan.minecraft.springBowel.item;

import com.wan.minecraft.springBowel.WanMod;
import com.wan.minecraft.springBowel.proxy.IHasAModel;
import com.wan.minecraft.springBowel.proxy.WanModItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

@WanModItem
public class DingDing extends WanModItemBase implements IHasAModel {

    public DingDing() {
        this.setRegistryName("spring_bowel:dingding").setCreativeTab(WanMod.springBowl).setUnlocalizedName("spring_bowel.ding");
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.getBiome(playerIn.getPosition()).equals(Biomes.HELL)) {
            if (Math.random() > 0.5) {
                if (!worldIn.isRemote) {
                    EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldIn, (double) ((float) playerIn.getPosition().getX() + 0.5F), (double) playerIn.getPosition().getY(), (double) ((float) playerIn.getPosition().getZ() + 0.5F), playerIn.getAttackingEntity());
                    entitytntprimed.setFuse((short) (worldIn.rand.nextInt(entitytntprimed.getFuse() / 4) + entitytntprimed.getFuse() / 8));
                    worldIn.spawnEntity(entitytntprimed);
                }
            }

            if (Math.random() > 0.5) {
                worldIn.setBlockState(playerIn.getPosition(), Blocks.LAVA.getDefaultState());

            }
        }

        if (worldIn.getBiome(playerIn.getPosition()).equals(Biomes.HELL)) {
            if (Math.random() > 0.9) {
                if (!worldIn.isRemote) {
                    EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldIn, (double) ((float) playerIn.getPosition().getX() + 0.5F), (double) playerIn.getPosition().getY(), (double) ((float) playerIn.getPosition().getZ() + 0.5F), playerIn.getAttackingEntity());
                    entitytntprimed.setFuse((short) (worldIn.rand.nextInt(entitytntprimed.getFuse() / 4) + entitytntprimed.getFuse() / 8));
                    worldIn.spawnEntity(entitytntprimed);
                }
            }

            if (Math.random() > 0.9) {
                worldIn.setBlockState(playerIn.getPosition(), Blocks.LAVA.getDefaultState());

            }
        }

        playerIn.getHeldItem(handIn).shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
