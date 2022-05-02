package tech.parkhurst.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;


public class Target extends GameObject {

    public Target(){
        x= (int) (Math.random()*(1260-16)+16);
        y= (int) (Math.random()*(700-16)+16);

        img = new Texture("./target.png");
    }


    protected void render(@NotNull SpriteBatch batch){
        batch.draw(img, x, y);
    }

    protected void newloc(){
        x= (int) (Math.random()*(1260-16)+16);
        y= (int) (Math.random()*(700-16)+16);
    }

}
