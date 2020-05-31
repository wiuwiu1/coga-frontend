package levels.cafe.components.ground.furniture;

import engine.graphics.Texture;
import engine.maths.Vector3f;
import levels.cafe.components.ground.AbstractFurniture;

public class Fridge extends AbstractFurniture {

    public Fridge() {
        texture = generateTexture();
    }

    @Override
    protected Texture generateTexture() {
        return new Texture("res/room/furnitures/objekt_fridge_front_l_0001.png");
    }
}
