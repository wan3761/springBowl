package com.wan.minecraft.springBowel.mixin;

import com.wan.minecraft.springBowel.config.ModConfig;
import com.wan.minecraft.springBowel.event.CreeperExplosionEvent;
import com.wan.minecraft.springBowel.item.ItemLists;
import com.wan.minecraft.springBowel.item.Silent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(EntityCreeper.class)
@Debug(export = true)
public abstract class MixinEntityCreeper {

    private final Random rand = new Random();
    private int timeSinceIgnited;

    @Shadow
    protected abstract void explode();


    @Shadow
    public abstract int getCreeperState();

    private int lastActiveTime;

    @Inject(method = "explode", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFZ)Lnet/minecraft/world/Explosion;"), cancellable = true)
    private void explodeAfterCreateExplosion(CallbackInfo ci) {
        boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(((EntityCreeper) (Object) this).world, ((EntityCreeper) (Object) this));
        MinecraftForge.EVENT_BUS.post(new CreeperExplosionEvent((EntityCreeper) (Object) this));
        if (((EntityCreeper) (Object) this).getCreeperState() == 2) {
            float f = ((EntityCreeper) (Object) this).getPowered() ? 2.0F : 1.0F;
            ((EntityCreeper) (Object) this).world.createExplosion(((EntityCreeper) (Object) this), ((EntityCreeper) (Object) this).posX, ((EntityCreeper) (Object) this).posY, ((EntityCreeper) (Object) this).posZ, ModConfig.creepStrength * (float) 3 * f, flag);
        }
    }

    /**
     * @author
     * @reason no why for study
     */
    @Overwrite()
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
            ((EntityCreeper) (Object) this).world.playSound(player, ((EntityCreeper) (Object) this).posX, ((EntityCreeper) (Object) this).posY, ((EntityCreeper) (Object) this).posZ, SoundEvents.ITEM_FLINTANDSTEEL_USE, ((EntityCreeper) (Object) this).getSoundCategory(), 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
            player.swingArm(hand);

            if (!((EntityCreeper) (Object) this).world.isRemote) {
                ((EntityCreeper) (Object) this).ignite();
                itemstack.damageItem(1, player);
                return true;
            }
        }

        if (itemstack.getItem() == ItemLists.get(Silent.class)) {
            ((EntityCreeper) (Object) this).world.playSound(player, ((EntityCreeper) (Object) this).posX, ((EntityCreeper) (Object) this).posY, ((EntityCreeper) (Object) this).posZ, SoundEvents.ITEM_FLINTANDSTEEL_USE, ((EntityCreeper) (Object) this).getSoundCategory(), 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
            player.swingArm(hand);

            if (!((EntityCreeper) (Object) this).world.isRemote) {
                ((EntityCreeper) (Object) this).setCreeperState(2);
                return true;
            }
        }

        return false;
    }
}
