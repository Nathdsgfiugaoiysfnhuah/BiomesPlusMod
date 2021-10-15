package naenaenz.biomes.plus.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class JungleStaff extends Item {
    public JungleStaff(Item.Settings settings)
    {
        super(settings.maxCount(1).maxDamage(250));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_AZALEA_PLACE, SoundCategory.NEUTRAL, 0.5F,(world.getRandom().nextFloat() * 0.4F + 0.4F));
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.WEATHER_RAIN, SoundCategory.NEUTRAL, 0.2F,(world.getRandom().nextFloat() * 0.4F + 1.6F));
        user.getItemCooldownManager().set(this, 200);
		if (!world.isClient) {
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,50,3));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100));
            itemStack.damage(1, user, player -> player.sendToolBreakStatus(hand));
            }
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		return TypedActionResult.success(itemStack, world.isClient());
	}

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damage(2, attacker, player -> player.sendToolBreakStatus(Hand.MAIN_HAND));
		return true;
	}
}
