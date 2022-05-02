package tech.parkhurst.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends GameObject {

    private Direction facing;
    public Texture img;

    public enum Direction{
        UP,DOWN,LEFT,RIGHT
    }

    /**
     * Constructor for the player.
     */
    public Player(int size) {
        //Setting Direction
        facing = Direction.RIGHT;

        //set WIDTH and HEIGHT
        width = height = size;

        //initial speed
        speed = width;

        lives = 3;
        img = new Texture("./circ.png");

        reset();
    }

    protected void render(SpriteBatch batch){
        batch.draw(img, x, y);
        return;
    }

    private void reset(){
        facing = Direction.RIGHT;
    }
}
