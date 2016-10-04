package com.jacktheogre.replay.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.jacktheogre.replay.GameWorld.*;
import com.jacktheogre.replay.InputHandler;
import com.jacktheogre.replay.ReplayBall;

/**
 * Created by luna on 04.10.16.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime; //mb pass it into GameRenderer

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth(); // TODO: 05.10.16 whaaat
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = ReplayBall.WIDTH;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        runTime = 0;

//        Gdx.app.log("GameScreen", "Attached");
        world = new GameWorld();
        renderer = new GameRenderer(world, (int) gameHeight);

        Gdx.input.setInputProcessor(new InputHandler(world.getBall(), world));
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render();
//        Gdx.app.log("GameScreen FPS", (1/delta) + "");
    }

    @Override
    public void resize(int width, int height) {
//        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {

    }
}
