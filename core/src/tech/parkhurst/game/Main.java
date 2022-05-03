package tech.parkhurst.game;
//Basic Snake Game
import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.ScreenUtils;


import tech.parkhurst.game.menus.EndScreen;


public class Main extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private BitmapFont scoreText;
	private Player myPlayer;
	private List<Wall> walls;
	private Target targ;
	private boolean isLive;


	@Override
	public void create () {
		isLive = true;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		batch = new SpriteBatch();
		//gameMusic = Gdx.audio.newSound(Gdx.files.internal("gameMusic.wav"));
		myPlayer = new Player(16);
		targ = new Target();
		scoreText = new BitmapFont(); //or use alex answer to use custom font
		walls = new ArrayList<Wall>();
		//generate 4 walls
		walls.add(new Wall(0,0,true));
		walls.add(new Wall(1248,0,true));
		walls.add(new Wall(0,0,false));
		walls.add(new Wall(0,688,false));
		isLive = true;
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
		if(isLive) {
			ScreenUtils.clear(0, 255, 0, 1);
			camera.update();
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			//Unit Rendering
			myPlayer.render(batch);
			targ.render(batch);
			//Wall Rendering
			for (int i = 0; i < walls.size(); i++) {
				walls.get(i).render(batch);
			}

			//Score Text
			scoreText.setColor(255, 0, 0, 1);
			scoreText.draw(batch, String.valueOf(myPlayer.score), 64, 656);
			batch.end();

			//Handle our Input!wda
			myPlayer.inputHandle();
			//Check Here if MyPlayer touches targ
			if (myPlayer.getX() + 16 >= targ.getX() && myPlayer.getX() <= targ.getX() + 16 && myPlayer.getY() + 16 >= targ.getY()
					&& myPlayer.getY() <= targ.getY() + 16) {
				//Delete target and creaate new
				myPlayer.score += 1;
				targ.newloc();
			}

			//Check if ESCape is pressed
			escapeMenu();
			//DEAD CODE
			//TEMPORARY TILL WE MAKE WALL OBJECT!
			if (myPlayer.x < 30) {
				isLive=false;
				myPlayer.x = 30;
			} else if (myPlayer.x > 1280 - 62) {
				isLive=false;
				myPlayer.x = 1280 - 62;
			}
			if (myPlayer.y < 30) {
				isLive=false;
				myPlayer.y = 30;
			} else if (myPlayer.y > 720 - 62) {
				isLive=false;
				myPlayer.y = 720 - 62;
			}
		}else{
			//Possibly Consider refactoring to package these into a struct
			EndScreen.runScreen(camera,batch,scoreText, myPlayer.score);
			escapeMenu();
		}
	}

	
	@Override
	public void dispose () {
		batch.dispose();

		myPlayer.disposeImg();
		targ.disposeImg();
		scoreText.dispose();
		for(int i = 0; i < walls.size(); i++){
			walls.get(i).disposeImg();
		}
	}
}
