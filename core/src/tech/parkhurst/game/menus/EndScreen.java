package tech.parkhurst.game.menus;

import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import org.jetbrains.annotations.NotNull;

public class EndScreen {

    public static void runScreen(@NotNull OrthographicCamera camera, @NotNull SpriteBatch batch, @NotNull BitmapFont scoreText, int score){
        //End Game
        ScreenUtils.clear(255, 0, 0, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        //Score Text
        scoreText.setColor(0, 0, 255, 1);
        scoreText.getData().setScale(2);
        scoreText.draw(batch, String.valueOf(score), 640, 360);
        batch.end();
        return;
    }
}
