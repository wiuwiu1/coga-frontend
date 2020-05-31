package engine.utils;

import engine.maths.Matrix4f;
import engine.maths.Vector3f;

public class Matrix4fUtil {

    private Matrix4fUtil(){}

    /**
     * @return  an indentity matrix (only diagonal 1)
     **/
    public static Matrix4f getIndentityMatrix(){
        Matrix4f result = new Matrix4f();

        result.elements[0 + 0 * 4] = 1.0f;
        result.elements[1 + 1 * 4] = 1.0f;
        result.elements[2 + 2 * 4] = 1.0f;
        result.elements[3 + 3 * 4] = 1.0f;

        return result;
    }

    /**
     * see http://learnwebgl.brown37.net/08_projections/projections_ortho.html
     * @param left
     * @param right
     * @param bottom
     * @param top
     * @param near
     * @param far
     * @return a orthographic matrix
     */
    public static Matrix4f getOrthographic(float left, float right, float bottom, float top, float near, float far) {
        Matrix4f result = getIndentityMatrix();

        result.elements[0 + 0 * 4] = 2.0f / (right - left);
        result.elements[3 + 0 * 4] = -(right+left)/(right-left);
        result.elements[1 + 1 * 4] = 2.0f / (top - bottom);
        result.elements[3 + 1 * 4] = -(top+bottom)/(top-bottom);
        result.elements[2 + 2 * 4] = -2.0f / (far-near);
        result.elements[3 + 2 * 4] = -(far+near)/(far-near);

        return result;
    }

    /**
     * see http://learnwebgl.brown37.net/transformations2/transformations_translate.html
     * and http://learnwebgl.brown37.net/transformations2/transformations_matrices.html
     * @param vector a vector where x, y and z descripe the offset in this direction
     * @return a translate matrix
     */
    public static Matrix4f translate(Vector3f vector){
        Matrix4f result = getIndentityMatrix();

        result.elements[3 + 0 * 4] = vector.x;
        result.elements[3 + 1 * 4] = vector.y;
        result.elements[3 + 2 * 4] = vector.z;

        return result;
    }

    /**
     * see http://learnwebgl.brown37.net/transformations2/transformations_rotate.html
     * and http://learnwebgl.brown37.net/transformations2/transformations_matrices.html
     * @param angle how much the matrix should be rotated
     * @return a rotation matrix for the z axis
     */
    public static Matrix4f rotateAtZ(float angle){
        Matrix4f result = getIndentityMatrix();
        float r = (float) Math.toRadians(angle);
        float cos = (float) Math.cos(r);
        float sin = (float) Math.sin(r);

        result.elements[0 + 0 * 4] = cos;
        result.elements[1 + 0 * 4] = -sin;
        result.elements[0 + 1 * 4] = sin;
        result.elements[1 + 1 * 4] = cos;

        return result;
    }
}
