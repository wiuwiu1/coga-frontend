package levels.cafe.components.ground;

import engine.graphics.Texture;
import engine.maths.Vector3f;

public class Meal extends AbstractGroundEntity {

    public Meal() {
        texture = generateTexture();
    }

    @Override
    protected Texture generateTexture() {
        return new Texture("res/room/meals/objekt_food_0001.png");
    }
}
