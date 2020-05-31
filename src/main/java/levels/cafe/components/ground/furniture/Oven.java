package levels.cafe.components.ground.furniture;

import engine.graphics.Texture;
import engine.maths.Vector3f;
import levels.cafe.components.ground.AbstractFurniture;

public class Oven extends AbstractFurniture {

    public Oven() {
        texture = generateTexture();
    }

    @Override
    protected Texture generateTexture() {
        return new Texture("res/room/furnitures/objekt_stove_front_l_0001.png");
    }
}
