package engine;

import engine.graphics.Shader;
import engine.maths.Matrix4f;
import engine.maths.Vector3f;
import engine.utils.Matrix4fUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Engine implements Runnable{

    private final Logger logger = LoggerFactory.getLogger(Engine.class);

    private final float MIN_ZOOM = 1.0f;
    private final float MAX_ZOOM = 50.0f;

    private float ratio = 9f / 16f;
    private float base = 15.0f;
    private Vector3f cameraOffset = new Vector3f(0, 0, 0);


    private WindowManager windowManager;

    public Engine(int windowWidth, int windowHeight){
        this.windowManager = new WindowManager(windowWidth, windowHeight, this);
    }

    @Override
    public void run() {
        windowManager.init();

        loadRoom();


        while (!windowManager.shouldClose()){
            windowManager.update();

        }
        windowManager.close();
    }

    private void loadRoom() {
        Shader.loadAllShader();

        Shader.roomShader.enable();
        setPrMatrix();
        Shader.roomShader.setUniform1i("tex", 0);
        Shader.roomShader.disable();

        windowManager.initRoom();
    }

    private void setPrMatrix(){
        Shader.roomShader.enable();
        Matrix4f pr_matrix = Matrix4fUtil.getOrthographic(-base, base, -base * ratio, base * ratio, -5.0f, 5.0f);
        Shader.roomShader.setUniformMatrix4f("pr_matrix", pr_matrix);
        Shader.roomShader.setUniformMatrix4f("tr_matrix", Matrix4fUtil.translate(cameraOffset));
        Shader.roomShader.disable();
    }


    public void addZoomDelta(double dy) {
        if(base - dy <= MAX_ZOOM && base - dy >= MIN_ZOOM){
            base -= dy;
            setPrMatrix();
        }
    }

    public void moveCamera(Vector3f vector3f) {
        cameraOffset = cameraOffset.addVector3f(vector3f);
        Shader.roomShader.enable();
        Shader.roomShader.setUniformMatrix4f("tr_matrix", Matrix4fUtil.translate(cameraOffset));
        Shader.roomShader.disable();
    }
}
