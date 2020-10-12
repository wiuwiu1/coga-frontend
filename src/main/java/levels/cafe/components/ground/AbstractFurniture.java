package levels.cafe.components.ground;

import levels.cafe.ZLevels;

import java.util.Objects;

public abstract class AbstractFurniture extends AbstractGroundObject {

    private AbstractGroundEntity entity;

    public float alterZ(float z){
        return z + ZLevels.FURNITURE_ADD.getLevel();
    }

    public boolean hasEntity(){
        return !Objects.isNull(entity);
    }

    public AbstractGroundEntity getEntity(){
        return entity;
    };

    public void setEntity(AbstractGroundEntity entity) {
        entity.configure(startVector);
        this.entity = entity;
    }
}
