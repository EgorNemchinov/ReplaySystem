package com.jacktheogre.replay;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by luna on 04.10.16.
 */
public class AssetLoader {

    public static Texture texture;

    public static void load() {
        texture = new Texture("circle.png");
    }

    public static void dispose() {
        texture.dispose();
    }
}
