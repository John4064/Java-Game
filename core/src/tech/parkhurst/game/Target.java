package tech.parkhurst.game;

import com.badlogic.gdx.graphics.Texture;


public class Target extends GameObject {

    public Target(){
        x= (int) (Math.random()*(1260-64)+64);
        y= (int) (Math.random()*(700-64)+64);

        img = new Texture("./target.png");
    }



    protected void newloc(){
        x= (int) (Math.random()*(1260-64)+32);
        y= (int) (Math.random()*(700-64)+64);
    }

}
