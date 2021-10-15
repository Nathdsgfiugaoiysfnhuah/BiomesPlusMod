package naenaenz.biomes.plus.client.renderers;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import naenaenz.biomes.plus.client.model.GargrunkelModel;
import naenaenz.biomes.plus.entity.GargrunkelEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GargrunkelGeoRenderer extends GeoEntityRenderer<GargrunkelEntity> {

    public GargrunkelGeoRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GargrunkelModel());
    }

    @Override
    public RenderLayer getRenderType(GargrunkelEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                     Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}