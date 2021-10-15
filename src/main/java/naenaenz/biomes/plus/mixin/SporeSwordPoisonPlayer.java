package naenaenz.biomes.plus.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import naenaenz.biomes.plus.BiomesPlusMain;
import naenaenz.biomes.plus.registry.RegisterItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

@Mixin(PlayerEntity.class)
public class SporeSwordPoisonPlayer {
    @ModifyVariable
    (at = @At ("HEAD"), method = "applyDamage(ZF)V")
    private DamageSource injected(DamageSource source)
    {
        if(source instanceof EntityDamageSource entityDamageSource)
		{
            if(entityDamageSource.getAttacker() instanceof LivingEntity attacker)
			{

                ItemStack handItem = attacker.getMainHandStack();
				if(handItem.getItem()==RegisterItems.SPORE_SWORD.asItem())
				{
                    ((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,50,3));
				}
			}
		}
        return source;
    }
}
