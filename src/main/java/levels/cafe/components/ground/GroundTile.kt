package levels.cafe.components.ground

import engine.graphics.Texture
import engine.graphics.TextureLoader
import engine.graphics.VertexArray
import engine.maths.Vector3f
import engine.AbstractComponent

import java.util.Objects

class GroundTile(val startVector: Vector3f) : AbstractComponent() {
    var furniture: AbstractFurniture? = null

    init {
        vertexArray = generateVertexArray()
        texture = generateTexture()
    }

    override fun generateVertexArray(): VertexArray {
        val vertices = floatArrayOf(startVector.x, startVector.y, Z_LEVEL, startVector.x + HORIZONTAL_OFFSET, startVector.y + VERTICAL_OFFSET, Z_LEVEL, startVector.x, startVector.y + HORIZONTAL_OFFSET, Z_LEVEL, startVector.x - HORIZONTAL_OFFSET, startVector.y + VERTICAL_OFFSET, Z_LEVEL)

        val indices = byteArrayOf(0, 1, 2, 0, 2, 3)

        val tcs = floatArrayOf(0.5f, 0f, 1f, -0.5f, 0.5f, -1f, 0f, -0.5f)
        return VertexArray(vertices, indices, tcs)
    }

    override fun generateTexture(): Texture {
        return TextureLoader.getTexture("res/room/ground_tiles/bottom_tile_0003.PNG")
    }

    fun hasFurniture(): Boolean {
        return !Objects.isNull(furniture)
    }

    companion object {
        private val Z_LEVEL = 0.0f
        val VERTICAL_OFFSET = 1f
        val HORIZONTAL_OFFSET = 2f
    }
}
