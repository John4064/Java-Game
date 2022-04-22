package tech.parkhurst.game;

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
		rainMusic.setVolume(0);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 255, 0, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bucketImg, bucket.x, bucket.y);
		batch.end();

		//Movement
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = touchPos.x - 64 / 2;
			bucket.y = touchPos.y - 64 / 2;
		}
		//System.out.println(Gdx.graphics.getFramesPerSecond());
		if(bucket.x < 0){
			bucket.x = 0;
		}else if(bucket.x > 1280 - 64){
			bucket.x = 1280 - 64;
		}
		if(bucket.y<0){
			bucket.y = 0;
		}else if(bucket.y > 720-64){
			bucket.y= 720-64;
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bucketImg.dispose();;
		rainMusic.dispose();
		dropSound.dispose();
	}
}
