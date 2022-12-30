package com.wan.minecraft.springBowel.mixin;

import com.wan.minecraft.springBowel.potion.PotionLists;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.potion.PotionEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityAICreeperSwell.class)
public abstract class MixinEntityAICreeperSwell {

    @Shadow
    EntityLivingBase creeperAttackTarget;

    @Shadow
    EntityCreeper swellingCreeper;

    @Inject(method = "updateTask", at = @At("HEAD"), cancellable = true)
    private void updateTask(CallbackInfo ci) {
        if (creeperAttackTarget == null){
            ci.cancel();
            return;
        }
        if (this.swellingCreeper.getDistanceSq(creeperAttackTarget) < 32) {
            creeperAttackTarget.addPotionEffect(new PotionEffect(PotionLists.deaf, 30, 1));
        }
        ci.cancel();
    }
}
