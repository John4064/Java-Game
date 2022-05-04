package tech.parkhurst.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;

public class Player extends GameObject {

    public Direction facing;

    public int length;

    public int score;

    public enum Direction{
        UP,DOWN,LEFT,RIGHT
    }

    /**
     * Constructor for the player.
     */
    public Player(int size) {
        //Setting Direction
        facing = Direction.UP;
        x=400;
        y=400;
        //set WIDTH and HEIGHT
        width = height = size;

        //Setting starter length
        length=1;

        //initial speed
        speed = width/6;

        img = new Texture("./circ.png");

        //reset();
    }
    @Override
    protected void render(@NotNull SpriteBatch batch){
        batch.draw(img, x, y);
        //Handles our charachters movement
        this.movement();
    }



    protected void inputHandle(){
        /**
         * @brief: This is whwere we handle the players input!
         */
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.facing = Direction.UP;
        }else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            this.facing = Direction.DOWN;
        }else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            this.facing = Direction.LEFT;
        }else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            this.facing = Direction.RIGHT;
        }
    }

    private void movement(){
        /**
         * @brief: This Handles our automatic movement system based on the players speed/Direction facing
         */
        if(this.facing == Direction.RIGHT){
            this.x += this.width/this.speed;
        }else if(this.facing == Direction.LEFT){
            this.x -= this.width/this.speed;
        }else if(this.facing == Direction.UP){
            this.y += this.height/this.speed;
        }else if(this.facing == Direction.DOWN){
            this.y -= this.height/this.speed;
        }
        return;
    }


}
