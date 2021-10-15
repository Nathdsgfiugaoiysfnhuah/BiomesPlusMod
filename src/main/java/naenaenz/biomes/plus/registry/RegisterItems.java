package naenaenz.biomes.plus.registry;

import naenaenz.biomes.plus.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    public static final JungleStaff JUNGLE_STAFF = new JungleStaff(new Item.Settings().group(ItemGroup.TOOLS));
    public static final JungleSoul JUNGLE_SOUL = new JungleSoul(new Item.Settings().group(ItemGroup.MISC));
    public static final ClimbingStick CLIMBING_STICK = new ClimbingStick(new Item.Settings().group(ItemGroup.TOOLS));
    public static final SporeSword SPORE_SWORD = new SporeSword(new Item.Settings().group(ItemGroup.COMBAT));
    public static final LivingIngot LIVING_INGOT = new LivingIngot(new Item.Settings().group(ItemGroup.MISC));

    public void Register() {
        Registry.register(Registry.ITEM, new Identifier("biomesplus", "jungle_staff"), JUNGLE_STAFF);
        Registry.register(Registry.ITEM, new Identifier("biomesplus", "jungle_soul"), JUNGLE_SOUL);
        Registry.register(Registry.ITEM, new Identifier("biomesplus", "climbing_stick"), CLIMBING_STICK);
        Registry.register(Registry.ITEM, new Identifier("biomesplus", "spore_sword"), SPORE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("biomesplus", "living_ingot"), LIVING_INGOT);
    }
}
