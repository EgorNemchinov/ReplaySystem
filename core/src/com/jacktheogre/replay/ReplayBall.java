package com.jacktheogre.replay;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jacktheogre.replay.screens.GameScreen;
import com.jacktheogre.replay.screens.MainMenuScreen;

public class ReplayBall extends Game {
	public static int WIDTH = 400;
	public static int HEIGHT = 240;
    public static int GAME_DURATION = 5;

	@Override
	public void create () {
		AssetLoader.load();
        setScreen(new GameScreen());
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

    // TODO: 05.10.16 add buttons for changecontrol, undo and redo km
    // TODO: 08.10.16 add screens. clear everything when playing again
}
