package levels.cafe;

import engine.Render;
import engine.maths.Vector3f;
import levels.Level;
import levels.cafe.components.ground.*;
import levels.cafe.components.wall.WallGrid;
import levels.cafe.components.wall.WallTile;

import java.util.List;

public class Room extends Level {
    private Player player;
    private GroundGrid groundGrid;
    private WallGrid wallGrid;
    private int tileRowSize;
    private Vector3f startVector;


    public Room(int tileRowSize, Vector3f startVector) {
        this.tileRowSize = tileRowSize;
        this.startVector = startVector;

        this.groundGrid = new GroundGrid(tileRowSize, startVector);
        this.groundGrid.generate();

        this.wallGrid = new WallGrid(tileRowSize, startVector);
        this.wallGrid.generate();
    }

    public void setFurniture(AbstractFurniture abstractFurniture, Vector3f groundVector){
        groundGrid.setFurniture(abstractFurniture, groundVector);
    }

    @Override
    public void updateLevel() {
        Render render = getRender();
        List<GroundTile> groundTiles = groundGrid.getGroundTiles();
        for(GroundTile groundTile: groundTiles){
            render.addComponent(groundTile);
            if(groundTile.hasFurniture()){
                AbstractFurniture furniture = groundTile.getFurniture();
                render.addComponent(furniture);
                if(furniture.hasEntity()){
                    render.addComponent(furniture.getEntity());
                }
            }
        }

        List<WallTile> wallTiles = wallGrid.getWallTiles();
        for(WallTile wallTile : wallTiles){
            wallTile.render();
        }

        player = new Player(groundTiles.get(0));
        render.addComponent(player);
    }
}
