package com.jacktheogre.replay.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jacktheogre.replay.ReplayBall;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Replay Ball";
        config.width = 400;
        config.height = 240;
		new LwjglApplication(new ReplayBall(), config);
	}
}
