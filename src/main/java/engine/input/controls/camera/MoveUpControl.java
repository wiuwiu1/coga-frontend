package engine.input.controls.camera;

import engine.Engine;
import engine.input.controls.AbstractControl;
import engine.maths.Vector3f;

public class MoveUpControl extends AbstractControl {

    private final static float SPEED = 0.1f;

    private Engine engine;

    public MoveUpControl(Engine engine){
        this.engine = engine;
    }

    @Override
    public void run() {
        engine.moveCamera(new Vector3f(0, -SPEED,0));
    }
}
