package levels.cafe.components.wall;

import engine.graphics.Texture;
import engine.maths.Vector3f;

public class WallTile extends AbstractWallObject{


    public WallTile(Vector3f startVector, WallOrientation wallOrientation){
        this.wallOrientation = wallOrientation;
        this.startVector = startVector;
        this.vertexArray = generateVertexArray();
        this.texture = generateTexture();
    }

    @Override
    protected Texture generateTexture() {
        if(wallOrientation == WallOrientation.LEFT){
            return new Texture("res/room/wall_tiles/wall_tile_l_0001.png");
        }
        return new Texture("res/room/wall_tiles/wall_tile_r_0001.png");
    }
}
