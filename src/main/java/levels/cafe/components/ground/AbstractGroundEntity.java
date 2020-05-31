package levels.cafe.components.ground;

import levels.cafe.components.ZLevels;

public abstract class AbstractGroundEntity extends AbstractGroundObject{

    public float alterZ(float z){
        return z + ZLevels.ENTITIES_ADD.getLevel();
    }
}
