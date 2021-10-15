package naenaenz.biomes.plus.registry;

import naenaenz.biomes.plus.client.renderers.GargrunkelGeoRenderer;
import naenaenz.biomes.plus.registry.EntityRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

public class RegisterModels {

    public void Register() {
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.GARGRUNKEL_ENTITY,
                (context) -> new GargrunkelGeoRenderer(context));
        ClientSidePacketRegistry.INSTANCE.register(software.bernie.example.ClientListener.EntityPacket.ID, (ctx, buf) -> {
            software.bernie.example.ClientListener.EntityPacketOnClient.onPacket(ctx, buf);
        });
    }
}
