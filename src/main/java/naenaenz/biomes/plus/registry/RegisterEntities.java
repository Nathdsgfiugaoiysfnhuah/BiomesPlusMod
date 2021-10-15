package naenaenz.biomes.plus.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import software.bernie.example.EntityUtils;

public class RegisterEntities {
    public void Register()
    {
        new EntityRegistry();
        FabricDefaultAttributeRegistry.register(EntityRegistry.GARGRUNKEL_ENTITY,
                EntityUtils.createGenericEntityAttributes());
    }
}
