package engine.graphics;

import engine.maths.Matrix4f;
import engine.maths.Vector3f;
import engine.utils.ShaderUtils;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

    public final static int VERTEX_ATTRIBUTE = 0;
    public final static int TEXTURE_ATTRIBUTE = 1;

    public static Shader roomShader;

    private final int ID;
    private Map<String, Integer> locationCache = new HashMap<>();

    public Shader (String vertPath, String fragPath){
        ID = ShaderUtils.createShaderProgram(vertPath, fragPath);
    }

    public static void loadAllShader(){
        roomShader = new Shader("shaders/room.vert", "shaders/room.frag");
    }

    public void setUniform1i(String name, int value){
        glUniform1i(getUniformLocation(name), value);
    }

    public void setUniform1f(String name, float value){
        glUniform1f(getUniformLocation(name), value);
    }

    public void setUniform2f(String name, float valueX, float valueY){
        glUniform2f(getUniformLocation(name), valueX, valueY);
    }

    public void setUniform3f(String name, Vector3f valueVector){
        glUniform3f(getUniformLocation(name), valueVector.x, valueVector.y, valueVector.z);
    }

    public void setUniformMatrix4f(String name, Matrix4f valueMatrix){
        //transpose must be true, because i switched row and column
        glUniformMatrix4fv(getUniformLocation(name), true, valueMatrix.toFloatBuffer());
    }

    private int getUniformLocation(String name) {
        if(locationCache.containsKey(name)){
            return locationCache.get(name);
        }

        int result = glGetUniformLocation(ID, name);
        if(result == -1){
            System.err.println("Could not find uniform " + name + " for shader program " + ID + "!");
        } else {
            locationCache.put(name, result);
        }
        return result;
    }

    public void enable(){
        glUseProgram(ID);
    }

    public void disable(){
        glUseProgram(0);
    }
}
