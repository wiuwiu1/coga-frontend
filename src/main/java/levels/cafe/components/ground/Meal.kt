package levels.cafe.components.ground

import engine.graphics.Texture
import engine.graphics.TextureLoader
import engine.maths.Vector3f

class Meal : AbstractGroundEntity() {
    init {
        texture = generateTexture()
    }

    override fun generateTexture(): Texture {
        return TextureLoader.getTexture("res/room/meals/objekt_food_0001.png")
    }
}
