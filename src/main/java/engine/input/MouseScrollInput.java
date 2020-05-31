package engine.input;

import engine.Engine;
import org.lwjgl.glfw.GLFWScrollCallback;

public class MouseScrollInput extends GLFWScrollCallback {

    private Engine engine;

    public MouseScrollInput(Engine engine){
        this.engine = engine;
    }

    @Override
    public void invoke(long win, double dx, double dy) {
        engine.addZoomDelta(dy);
    }
}
