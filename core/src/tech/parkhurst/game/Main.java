package tech.parkhurst.game;
//Basic Snake Game
import java.util.Random;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
// add this import and NOT the one in the standard library
import com.badlogic.gdx.math.Rectangle;

public class Main extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture playerImg;

	private Player MyPlayer;

	private Target targ;

	//Array List

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		batch = new SpriteBatch();
		//gameMusic = Gdx.audio.newSound(Gdx.files.internal("gameMusic.wav"));
		MyPlayer = new Player(16);
		targ = new Target();

		// start the playback of the background music immediately
	}
	private void escapeMenu(){
		/**
		 * @brief: The menu stuff will go here later
		 */
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
		return;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 255, 0, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		MyPlayer.render(batch);
		//Must Handle Rendering targets differently since new ones destroyed constantly potentially arraylist?
		targ.render(batch);

		batch.end();

		//Handle our Input!
		MyPlayer.inputHandle();
		//Check Here if MyPlayer touches targ



		//Check if ESCape is pressed
		escapeMenu();

			//DEAD CODE
		//TEMPORARY TILL WE MAKE WALL OBJECT!
		if(MyPlayer.x < 0){
			MyPlayer.x = 0;
		}else if(MyPlayer.x > 1280 - 32){
			MyPlayer.x = 1280 - 32;
		}
		if(MyPlayer.y<0){
			MyPlayer.y = 0;
		}else if(MyPlayer.y > 720-32){
			MyPlayer.y= 720-32;
		}

	}

	
	@Override
	public void dispose () {
		batch.dispose();
		MyPlayer.disposeImg();
		targ.disposeImg();

	}
}
