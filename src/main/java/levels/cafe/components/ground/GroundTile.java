package levels.cafe.components.ground;

import engine.graphics.Texture;
import engine.graphics.VertexArray;
import engine.maths.Vector3f;
import engine.AbstractComponent;

import java.util.Objects;

public class GroundTile extends AbstractComponent {

    private final static float Z_LEVEL = 0.0f;
    public final static float VERTICAL_OFFSET = 1;
    public final static float HORIZONTAL_OFFSET = 2;

    private final Vector3f startVector;
    private AbstractFurniture furniture;

    public GroundTile(Vector3f startVector) {
        this.startVector = startVector;
        vertexArray = generateVertexArray();
        texture = generateTexture();
    }

    @Override
    protected VertexArray generateVertexArray() {
        float[] vertices = new float[]{
                startVector.x, startVector.y, Z_LEVEL,
                startVector.x + HORIZONTAL_OFFSET, startVector.y + VERTICAL_OFFSET, Z_LEVEL,
                startVector.x, startVector.y + HORIZONTAL_OFFSET, Z_LEVEL,
                startVector.x - HORIZONTAL_OFFSET, startVector.y + VERTICAL_OFFSET, Z_LEVEL,
        };

        byte[] indices = new byte[]{
                0, 1, 2,
                0, 2, 3
        };

        float[] tcs = new float[]{
                0.5f, 0,
                1, -0.5f,
                0.5f, -1,
                0, -0.5f
        };
        return new VertexArray(vertices, indices, tcs);
    }

    @Override
    protected Texture generateTexture() {
        return new Texture("res/room/ground_tiles/bottom_tile_0003.PNG");
    }


    public AbstractFurniture getFurniture() {
        return furniture;
    }

    public void setFurniture(AbstractFurniture furniture) {
        this.furniture = furniture;
    }

    public Vector3f getStartVector() {
        return startVector;
    }

    public boolean hasFurniture() {
        return !Objects.isNull(furniture);
    }
}
