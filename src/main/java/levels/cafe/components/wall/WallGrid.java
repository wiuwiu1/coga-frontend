package levels.cafe.components.wall;

import engine.maths.Vector3f;
import levels.cafe.components.ZLevels;

import java.util.List;

public class WallGrid {

    private final static float Z_LEVEL = ZLevels.WALL_TILE.getLevel();
    private int tileRowSize;
    private Vector3f startVector;
    private List<WallTile> wallTiles;

    public WallGrid(int tileRowSize, Vector3f startVector){
        this.tileRowSize = tileRowSize;
        this.startVector = startVector;
    }

}
