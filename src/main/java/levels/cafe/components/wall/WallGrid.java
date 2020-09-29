package levels.cafe.components.wall;

import engine.maths.Vector3f;
import levels.cafe.components.ZLevels;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
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

    public void generate(){
        this.wallTiles = new ArrayList<>();
        wallTiles.add(new WallTile(new Vector3f(startVector.x, startVector.y, 1), WallOrientation.LEFT));
        wallTiles.add(new WallTile(new Vector3f(startVector.x, startVector.y, 1), WallOrientation.RIGHT));
        /*
        for (int x = 0; x < tileRowSize; x++) {
            wallTiles.add(new WallTile(new Vector3f(startVector.x, startVector.y, Z_LEVEL), WallOrientation.LEFT));
            wallTiles.add(new WallTile(new Vector3f(startVector.x, startVector.y, Z_LEVEL), WallOrientation.RIGHT));
        }
         */
    }

    public List<WallTile> getWallTiles() {
        return wallTiles;
    }
}
