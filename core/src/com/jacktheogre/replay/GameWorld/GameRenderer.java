package com.jacktheogre.replay.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.jacktheogre.replay.AssetLoader;
import com.jacktheogre.replay.ReplayBall;

/**
 * Created by luna on 04.10.16.
 */
public class GameRenderer {

    private final int gameHeight;
    private GameWorld world;
    private OrthographicCamera camera;
    SpriteBatch spriteBatch;


    public GameRenderer(GameWorld world, int gameHeight) {
        this.world = world;
        this.gameHeight = gameHeight;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, ReplayBall.WIDTH, ReplayBall.HEIGHT);
        spriteBatch = new SpriteBatch();
    }

    public void render() {
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Fills the screen with the selected color

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.ball, world.getBall().getX(), world.getBall().getY(),
               world.getBall().getWidth(), world.getBall().getHeight());
        spriteBatch.draw(AssetLoader.box, world.getBox().getX(), world.getBox().getY(),
                world.getBox().getWidth(), world.getBox().getHeight());

        spriteBatch.end();

    }
}
