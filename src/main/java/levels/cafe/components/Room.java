package levels.cafe.components;

import engine.Render;
import engine.maths.Vector3f;
import levels.cafe.components.ground.*;
import levels.cafe.components.wall.WallGrid;

import java.util.List;

public class Room {

    private GroundGrid groundGrid;
    private WallGrid wallGrid;
    private int tileRowSize;
    private Vector3f startVector;
    private Render render = new Render();

    public Room(int tileRowSize, Vector3f startVector) {
        this.tileRowSize = tileRowSize;
        this.startVector = startVector;
        this.groundGrid = new GroundGrid(tileRowSize, startVector);
        this.groundGrid.generate();
    }

    public void setFurniture(AbstractFurniture abstractFurniture, Vector3f groundVector){
        groundGrid.setFurniture(abstractFurniture, groundVector);
    }

    public void updateRoom(){
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
    }


    public void render() {
        render.render();
    }


}
