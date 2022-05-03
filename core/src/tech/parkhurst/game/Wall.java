package tech.parkhurst.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;

public class Wall extends GameObject{

    public Wall(int x,int y, boolean isVertical){
        this.x = x;
        this.y = y;
        if(isVertical){
            img = new Texture("./vertwall.png");
        }else{
            img = new Texture("./horizwall.png");
        }
    }



}
