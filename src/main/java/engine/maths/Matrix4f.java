package engine.maths;



import engine.utils.BufferUtils;

import java.nio.FloatBuffer;

public class Matrix4f {

    public static final int SIZE = 4 * 4;
    public float[] elements = new float[SIZE];

   public Matrix4f multiply (Matrix4f matrix) {
       Matrix4f result = new Matrix4f();
       for(int row = 0; row < 4; row++){
           for(int column = 0; column < 4; column++){
               float sum = 0f;
               for(int i = 0; i < 4; i++){
                    sum += matrix.elements[i + row * 4] * this.elements[column + i * 4];
               }
               result.elements[column + row * 4] = sum;
           }
       }
       return result;
   }

   public FloatBuffer toFloatBuffer(){
       return BufferUtils.createFloatBuffer(elements);
   }

}
