package naenaenz.biomes.plus;

import io.netty.buffer.Unpooled;
import naenaenz.biomes.plus.client.renderers.GargrunkelGeoRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import naenaenz.biomes.plus.registry.EntityRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.PacketContext;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.GeckoLib;

import java.util.UUID;

public class ClientListener implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.GARGRUNKEL_ENTITY,
                (context) -> new GargrunkelGeoRenderer(context));
        ClientSidePacketRegistry.INSTANCE.register(software.bernie.example.ClientListener.EntityPacket.ID, (ctx, buf) -> {
            software.bernie.example.ClientListener.EntityPacketOnClient.onPacket(ctx, buf);
        });
    }
}
