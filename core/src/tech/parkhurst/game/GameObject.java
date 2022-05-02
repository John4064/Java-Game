package tech.parkhurst.game;

public class GameObject {

    //Attributes
    float x;
    float y;

    int lives;

    float speed;

    float width;
    float height;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setPos(float x,float y) {
        this.x = x;
        this.y = y;
    }

    public float getWidth() {
        return width;
    }


    public float getHeight() {
        return height;
    }



}
