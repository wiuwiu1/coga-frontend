package levels.cafe.components.ground;

import engine.graphics.VertexArray;
import engine.maths.Vector3f;
import engine.AbstractComponent;

public abstract class AbstractGroundObject extends AbstractComponent {

    public final static float VERTICAL_TILE_OFFSET = 1;
    public final static float HORIZONTAL_TILE_OFFSET = 2;
    public final static float HEIGHT = 8;

    protected Vector3f startVector = new Vector3f(0, 0, 0);

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

        System.out.println(VERTICAL_TILE_OFFSET);

        float[] tcs = new float[]{
                0.5f, 0,
                1, -0.125f,
                0, -0.125f,
                1, -1,
                0, -1
        };
        return new VertexArray(vertices, indices, tcs);
    }

    public void configure(Vector3f startVector){
        this.zLevel = alterZ(startVector.z);

        this.startVector = startVector;
        this.startVector.z = zLevel;

        this.vertexArray = generateVertexArray();
    }

    public abstract float alterZ(float z);

}
