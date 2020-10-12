package levels.cafe.components.wall

import engine.graphics.Texture
import engine.graphics.TextureLoader
import engine.maths.Vector3f

class WallTile(startVector: Vector3f, wallOrientation: WallOrientation) : AbstractWallObject() {

    init {
        this.wallOrientation = wallOrientation
        this.startVector = startVector
        this.vertexArray = generateVertexArray()
        this.texture = generateTexture()
    }

    override fun generateTexture(): Texture {
        return if (wallOrientation == WallOrientation.LEFT) {
            TextureLoader.getTexture("res/room/wall_tiles/wall_tile_l_0001.png")
        } else {
            TextureLoader.getTexture("res/room/wall_tiles/wall_tile_r_0001.png")
        }
    }
}
