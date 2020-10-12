package levels.cafe.components.wall;

import engine.AbstractComponent;
import engine.graphics.VertexArray;
import engine.maths.Vector3f;

public abstract class AbstractWallObject extends AbstractComponent {

    public final static float VERTICAL_TILE_OFFSET = 1;
    public final static float HORIZONTAL_TILE_OFFSET = 2;
    public final static float HEIGHT = 10;

    protected Vector3f startVector = new Vector3f(0, 0, 0);
    protected WallOrientation wallOrientation;

    @Override
    protected VertexArray generateVertexArray() {
        float[] vertices = new float[]{
                startVector.x, startVector.y, zLevel,
                startVector.x + HORIZONTAL_TILE_OFFSET, startVector.y + VERTICAL_TILE_OFFSET, zLevel,
                startVector.x - HORIZONTAL_TILE_OFFSET, startVector.y + VERTICAL_TILE_OFFSET, zLevel,
                startVector.x + HORIZONTAL_TILE_OFFSET, startVector.y + HEIGHT, zLevel,
                startVector.x - HORIZONTAL_TILE_OFFSET, startVector.y + HEIGHT, zLevel
        };

        byte[] indices = new byte[]{
                0, 1, 2,
                1, 2, 4,
                1, 3, 4
        };

        float[] tcs = new float[]{
                0.5f, 0,
                1, -0.1f,
                0, -0.1f,
                1, -1,
                0, -1
        };
        return new VertexArray(vertices, indices, tcs);
    }
}
