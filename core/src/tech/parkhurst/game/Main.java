package tech.parkhurst.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
// add this import and NOT the one in the standard library
import com.badlogic.gdx.math.Rectangle;

public class Main extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture bucketImg;
	private Texture drop;
	private Sound dropSound;
	private Music rainMusic;


	private Rectangle bucket;


	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		batch = new SpriteBatch();
		bucketImg = new Texture("./bucket.png");
		drop = new Texture("./drop.png");
		dropSound = Gdx.audio.newSound(Gdx.files.internal("raindrop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("undertree.mp3"));

		//Bucket
		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;




		// start the playback of the background music immediately
		rainMusic.setLooping(true);
		rainMusic.play();
		rainMusic.setVolume(1);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 255, 0, 1);
		batch.begin();

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
