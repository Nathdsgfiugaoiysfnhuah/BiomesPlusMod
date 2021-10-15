package naenaenz.biomes.plus.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ClimbingStick extends Item {
    public ClimbingStick(Item.Settings settings) {
        super(settings.maxCount(1).maxDamage(75));
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        Vec3d pos = context.getHitPos();
        PlayerEntity playerEntity = context.getPlayer();
        assert playerEntity != null;
        if (playerEntity.isOnGround()) {
            ItemStack itemStack = context.getStack();
            World world = context.getWorld();
            playerEntity.getItemCooldownManager().set(this, 15);
            itemStack.damage(1, playerEntity, player -> player.sendToolBreakStatus(context.getHand()));
            Vec3d PlayerPos = playerEntity.getEyePos();
            double coef = 0.7d;
            double px = PlayerPos.x;
            double py = PlayerPos.y;
            double pz = PlayerPos.z;
            world.playSound((PlayerEntity) null, px, py, pz, SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.NEUTRAL,
                    1.0f, world.getRandom().nextFloat() * 0.4f + 0.8f);
            double bx = pos.x;
            double by = pos.y;
            double bz = pos.z;
            double dx = px - bx;
            double dy = py - by;
            double dz = pz - bz;
            Vec3d vel = new Vec3d(dx, dy, dz).normalize();
            if (world.isClient) {
                playerEntity.addVelocity(vel.x * coef, vel.y * coef, vel.z * coef);
                playerEntity.velocityDirty = true;
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damage(2, attacker, player -> player.sendToolBreakStatus(Hand.MAIN_HAND));
		return true;
	}
}
