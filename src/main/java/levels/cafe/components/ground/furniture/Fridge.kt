package levels.cafe.components.ground.furniture

import engine.graphics.Texture
import engine.graphics.TextureLoader
import engine.maths.Vector3f
import levels.cafe.components.ground.AbstractFurniture

class Fridge : AbstractFurniture() {
    init {
        texture = generateTexture()
    }

    override fun generateTexture(): Texture {
        return TextureLoader.getTexture("res/room/furnitures/objekt_fridge_front_l_0001.png")
    }
}
