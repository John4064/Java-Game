package tech.parkhurst.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;


public class Target extends GameObject {

    public Target(){
        x= (int) (Math.random()*(1260-32)+32);
        y= (int) (Math.random()*(700-32)+32);

        img = new Texture("./target.png");
    }



    protected void newloc(){
        x= (int) (Math.random()*(1260-32)+32);
        y= (int) (Math.random()*(700-32)+32);
    }

}
