package engine.maths;

public class Vector3f {

    public float x, y, z;

    public Vector3f(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f addVector3f(Vector3f vector){
        return new Vector3f(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    public Vector3f invertVector3f(){
        return new Vector3f(-x, -y, -z);
    }
}
