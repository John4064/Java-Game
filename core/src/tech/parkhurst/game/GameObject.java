package tech.parkhurst.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;

public class GameObject {

    //Attributes
    float x;
    float y;

    public Texture img;

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

    public void disposeImg(){
        img.dispose();
    }
    protected void render(@NotNull SpriteBatch batch){
        batch.draw(img, x, y);
    }

}
