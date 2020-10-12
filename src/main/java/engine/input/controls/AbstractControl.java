package engine.input.controls;

import engine.Engine;

public abstract class AbstractControl {
    protected Engine engine;

    public AbstractControl(Engine engine){
        this.engine = engine;
    }

    public abstract void run();
}
