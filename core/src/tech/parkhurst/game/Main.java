package tech.parkhurst.game;
//Basic Snake Game
import java.util.Random;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
	private Texture drop;

	private Rectangle player;

	private Player MyPlayer;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		batch = new SpriteBatch();
		playerImg = new Texture("./circ.png");
		//gameMusic = Gdx.audio.newSound(Gdx.files.internal("gameMusic.wav"));
		//Bucket
		/*player = new Rectangle();
		player.x = 300;
		player.y = 300;
		player.width = 32;
		player.height = 32;
		 */
		MyPlayer = new Player(16);


		// start the playback of the background music immediately
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 255, 0, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		MyPlayer.render(batch);
		//batch.draw(playerImg, player.x, player.y);
		batch.end();

		//Get input here
		//Depending on Direction move my player
		if(MyPlayer.facing == Player.Direction.RIGHT){

			MyPlayer.x += MyPlayer.width/MyPlayer.speed;
		}else if(MyPlayer.facing == Player.Direction.LEFT){
			MyPlayer.x -= MyPlayer.width/MyPlayer.speed;
		}else if(MyPlayer.facing == Player.Direction.UP){
			System.out.println(5);
			MyPlayer.y += MyPlayer.height/MyPlayer.speed;
		}else if(MyPlayer.facing == Player.Direction.DOWN){
			MyPlayer.y -= MyPlayer.height/MyPlayer.speed;

		}


		/*
		//System.out.println(Gdx.graphics.getFramesPerSecond());
		if(player.x < 0){
			player.x = 0;
		}else if(player.x > 1280 - 64){
			player.x = 1280 - 64;
		}
		if(player.y<0){
			player.y = 0;
		}else if(player.y > 720-64){
			player.y= 720-64;
		}
		*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerImg.dispose();;
	}
}
