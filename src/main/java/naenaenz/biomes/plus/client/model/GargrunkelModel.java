package naenaenz.biomes.plus.client.model;

import net.minecraft.util.Identifier;
import naenaenz.biomes.plus.entity.GargrunkelEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GargrunkelModel extends AnimatedGeoModel<GargrunkelEntity> {
    @Override
    public Identifier getAnimationFileLocation(GargrunkelEntity entity) {
        return new Identifier("biomesplus", "animations/gargrunkel.idle.animation.json");
    }

    @Override
    public Identifier getModelLocation(GargrunkelEntity entity) {
        return new Identifier("biomesplus", "geo/gargrunkel.geo.json");
    }

    @Override
    public Identifier getTextureLocation(GargrunkelEntity entity) {
        return new Identifier("biomesplus", "textures/model/entity/gargrunkel.png");
    }
}