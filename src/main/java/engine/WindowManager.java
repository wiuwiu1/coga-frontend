package engine;

import engine.input.KeyInput;
import engine.input.MouseScrollInput;
import engine.maths.Vector3f;
import levels.cafe.components.Room;
import levels.cafe.components.ground.furniture.Fridge;
import levels.cafe.components.ground.Meal;
import levels.cafe.components.ground.furniture.Oven;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class WindowManager {
    private long window;
    private int windowWidth;
    private int windowHeight;

    private Room room;
    private Engine engine;

    public WindowManager(int windowWidth, int windowHeight, Engine engine){
        this.engine = engine;
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
    }

    public void init(){
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(windowWidth, windowHeight, "Hello World!", NULL, NULL);

        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        glfwSetKeyCallback(window, new KeyInput(engine));
        glfwSetScrollCallback(window, new MouseScrollInput(engine));

        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }



        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);




        // Make the window visible
        glfwShowWindow(window);

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        glEnable(GL_DEPTH_TEST);


        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable( GL_BLEND );

        glClearColor(1, 1, 1, 1f);

        //changes the texture or something
        glActiveTexture(GL_TEXTURE0);
    }

    public boolean shouldClose(){
        return glfwWindowShouldClose(window);
    }

    public void update(){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

        room.render();

        glfwSwapBuffers(window); // swap the color buffers

        // Poll for window events. The key callback above will only be
        // invoked during this call.
        glfwPollEvents();
    }

    public void close(){
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void initRoom(){
        room = new Room(7, new Vector3f(0, 6f, 0));

        room.setFurniture(new Fridge(), new Vector3f(0, 1, 0));
        Oven oven = new Oven();
        room.setFurniture(oven, new Vector3f(0, 2, 0));
        oven.setEntity(new Meal());

        room.setFurniture(new Fridge(), new Vector3f(1, 2, 0));
        room.setFurniture(new Fridge(), new Vector3f(2, 5, 0));

        oven = new Oven();
        room.setFurniture(oven, new Vector3f(3, 1, 0));
        oven.setEntity(new Meal());

        oven = new Oven();
        room.setFurniture(oven, new Vector3f(3, 5, 0));
        oven.setEntity(new Meal());

        room.setFurniture(new Fridge(), new Vector3f(4, 0, 0));

        oven = new Oven();
        room.setFurniture(oven, new Vector3f(5, 3, 0));
        oven.setEntity(new Meal());

        room.setFurniture(new Fridge(), new Vector3f(6, 3, 0));
        room.updateRoom();
    }
}
