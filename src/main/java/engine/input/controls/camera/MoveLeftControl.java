package engine.input.controls.camera;

import engine.Engine;
import engine.input.controls.AbstractControl;
import engine.maths.Vector3f;

public class MoveLeftControl extends AbstractControl {

    private final static float SPEED = 0.1f;

    private Engine engine;

    public MoveLeftControl(Engine engine){
        this.engine = engine;
    }

    @Override
    public void run() {
        engine.moveCamera(new Vector3f(SPEED, 0 ,0));
    }
}
