package com.jacktheogre.replay;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by luna on 04.10.16.
 */
public class AssetLoader {

    public static Texture ball, box;

    public static void load() {
        ball = new Texture("circle.png");
        box = new Texture("rect.png");
    }

    public static void dispose() {
        box.dispose();
        ball.dispose();
    }
}
