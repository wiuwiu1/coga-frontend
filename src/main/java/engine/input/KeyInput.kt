package engine.input

import engine.Engine
import engine.input.controls.AbstractControl
import engine.input.controls.camera.MoveDownControl
import engine.input.controls.camera.MoveLeftControl
import engine.input.controls.camera.MoveRightControl
import engine.input.controls.camera.MoveUpControl
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFWKeyCallback
import java.util.*

class KeyInput(engine: Engine?) : GLFWKeyCallback() {

    override fun invoke(window: Long, key: Int, scancode: Int, action: Int, mods: Int) {
        if (action != GLFW.GLFW_RELEASE) {
            if (controls.containsKey(key)) {
                controls[key]!!.run()
            }
        }
    }

    companion object {
        private val keysStatus = BooleanArray(65536)
        private val controls: MutableMap<Int, AbstractControl> = HashMap()
    }

    init {
        controls[GLFW.GLFW_KEY_W] = MoveUpControl(engine)
        controls[GLFW.GLFW_KEY_S] = MoveDownControl(engine)
        controls[GLFW.GLFW_KEY_A] = MoveLeftControl(engine)
        controls[GLFW.GLFW_KEY_D] = MoveRightControl(engine)
    }
}