package levels.cafe.components.ground;

import engine.maths.Vector3f;
import levels.cafe.Player;
import levels.cafe.ZLevels;

import java.util.ArrayList;
import java.util.List;

public class GroundGrid {

    private final static float Z_LEVEL = ZLevels.BASE_GROUND_TILE.getLevel();
    private int tileRowSize;
    private Vector3f startVector;
    private List<GroundTile> groundTiles;
    private Player player;

    public GroundGrid(int tileRowSize, Vector3f startVector){
        this.tileRowSize = tileRowSize;
        this.startVector = startVector;
    }

    public void generate() {
        groundTiles = new ArrayList<>();
        for (int x = 0; x < tileRowSize; x++) {
            for (int y = 0; y < tileRowSize; y++) {
                groundTiles.add(new GroundTile(new Vector3f(startVector.x + GroundTile.Companion.getHORIZONTAL_OFFSET() * x - GroundTile.Companion.getHORIZONTAL_OFFSET() * y ,
                        startVector.y - GroundTile.Companion.getVERTICAL_OFFSET() * x - GroundTile.Companion.getVERTICAL_OFFSET() * y,
                        Z_LEVEL + ((x + y) * ZLevels.GROUND_OFFSET_ADD.getLevel()))));
            }
        }
    }


    public void setFurniture(AbstractFurniture abstractFurniture, Vector3f groundVector) {
        GroundTile tile = groundTiles.get((int) (groundVector.x * tileRowSize + groundVector.y));
        abstractFurniture.configure(tile.getStartVector());
        tile.setFurniture(abstractFurniture);
    }

    public List<GroundTile> getGroundTiles() {
        return groundTiles;
    }
}
