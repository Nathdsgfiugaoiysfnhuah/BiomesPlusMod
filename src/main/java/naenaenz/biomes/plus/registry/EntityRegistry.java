package naenaenz.biomes.plus.registry;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import naenaenz.biomes.plus.entity.GargrunkelEntity;
import software.bernie.example.entity.GeoExampleEntity;
import software.bernie.example.entity.RocketProjectile;
import software.bernie.example.registry.EntityRegistryBuilder;
import software.bernie.geckolib3.GeckoLib;

public class EntityRegistry {
    public static final EntityType<GargrunkelEntity> GARGRUNKEL_ENTITY = buildEntity(GargrunkelEntity::new, GargrunkelEntity.class, 0.5f, 0.6F,
            SpawnGroup.MISC);

    public static <T extends Entity> EntityType<T> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass,
                                                               float width, float height, SpawnGroup group) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            String name = entityClass.getSimpleName().toLowerCase();
            return EntityRegistryBuilder.<T>createBuilder(new Identifier("biomesplus", name)).entity(entity)
                    .category(group).dimensions(EntityDimensions.changing(width, height)).build();
        }
        return null;
    }

}