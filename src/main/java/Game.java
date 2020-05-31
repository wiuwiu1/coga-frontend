import engine.Engine;
import engine.WindowManager;
import engine.input.KeyInput;
import org.lwjgl.glfw.GLFW;

public class Game {
    public static void main(String[] args) {
        Thread engineThread = new Thread(new Engine(1600, 900), "Engine");
        engineThread.start();
    }
}
