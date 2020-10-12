package levels.cafe

import engine.graphics.Texture
import engine.graphics.TextureLoader
import levels.cafe.components.ground.AbstractGroundObject
import levels.cafe.components.ground.GroundGrid
import levels.cafe.components.ground.GroundTile

class Player(groundTile: GroundTile) : AbstractGroundObject() {

    init {
        texture = generateTexture()
        configure(groundTile.startVector)
    }

    override fun generateTexture(): Texture {
        return TextureLoader.getTexture("res/placeholder.png")
    }

    override fun alterZ(z: Float): Float {
        return z
    }
}


