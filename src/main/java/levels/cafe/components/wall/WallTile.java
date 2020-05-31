package levels.cafe.components.wall;

import engine.graphics.Texture;

public class WallTile extends AbstractWallObject{

    @Override
    protected float alterZ(float z) {
        return z;
    }

    @Override
    protected Texture generateTexture() {
        return new Texture("");
    }
}
