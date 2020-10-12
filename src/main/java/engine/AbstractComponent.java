package engine;

import engine.graphics.Shader;
import engine.graphics.Texture;
import engine.graphics.VertexArray;

import java.awt.*;

public abstract class AbstractComponent {

    public VertexArray vertexArray;
    public Texture texture;
    protected float zLevel;

    protected abstract VertexArray generateVertexArray();
    protected abstract Texture generateTexture();

    public void render(){
        texture.bind();
        Shader.roomShader.enable();
        vertexArray.render();
        Shader.roomShader.disable();
        texture.unbind();
    }

    public void mousePickingRender(Color mousePickingColor){
        //todo
    }

}
