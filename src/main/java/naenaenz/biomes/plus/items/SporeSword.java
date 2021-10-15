package naenaenz.biomes.plus.items;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;

public class SporeSword extends SwordItem {
    public SporeSword(Item.Settings settings)
    {
        super(ToolMaterials.IRON,4,-2.4f,settings);
    }
    
    // now handled by mixin
    // //only works with players attacking
    // public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
	// 	target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,50,3));
    //     stack.damage(1, attacker, player -> player.sendToolBreakStatus(Hand.MAIN_HAND));
	// 	return true;
	// }
}
