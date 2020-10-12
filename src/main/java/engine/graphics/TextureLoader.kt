package engine.graphics

import java.util.*

object TextureLoader {
    private val textureMap = HashMap<String, Texture>()

    fun getTexture(path: String): Texture {
        if (textureMap[path] != null) {
            return textureMap[path]!!
        }
        val texture = Texture(path)
        textureMap[path] = texture
        return texture
    }
}
