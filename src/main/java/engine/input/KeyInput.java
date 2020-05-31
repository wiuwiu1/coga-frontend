package engine.input;

import engine.Engine;
import engine.input.controls.AbstractControl;
import engine.input.controls.camera.MoveDownControl;
import engine.input.controls.camera.MoveLeftControl;
import engine.input.controls.camera.MoveRightControl;
import engine.input.controls.camera.MoveUpControl;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

import java.util.HashMap;
import java.util.Map;

public class KeyInput extends GLFWKeyCallback{

    private static final boolean[] keysStatus = new boolean[65536];
    private static final Map<Integer, AbstractControl> controls = new HashMap<>();

    public KeyInput(Engine engine){
        controls.put(GLFW.GLFW_KEY_W, new MoveUpControl(engine));
        controls.put(GLFW.GLFW_KEY_S, new MoveDownControl(engine));
        controls.put(GLFW.GLFW_KEY_A, new MoveLeftControl(engine));
        controls.put(GLFW.GLFW_KEY_D, new MoveRightControl(engine));
    }

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        if(action != GLFW.GLFW_RELEASE){
            if(controls.containsKey(key)) {
                controls.get(key).run();
            }
        }
    }

}
