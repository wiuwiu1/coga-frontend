package levels

import engine.Render

abstract class Level {

    val render = Render()

    fun render() {
        render.render()
    }

    abstract fun updateLevel()
}