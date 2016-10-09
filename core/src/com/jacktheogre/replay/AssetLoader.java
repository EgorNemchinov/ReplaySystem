package com.jacktheogre.replay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by luna on 04.10.16.
 */
public class AssetLoader {

    public static Texture ball, box;
    public static FileHandle fileHandle;
    public static BitmapFont font;

    public static void load() {
        ball = new Texture("circle.png");
        box = new Texture("rect.png");
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        font.getData().setScale(0.5f, -0.5f);

        fileHandle = Gdx.files.external("log.txt");
        fileHandle.writeString("", false);
        printLog();
    }

    public static void logString(String s) {
        fileHandle.writeString(s, true);
        printLog();
    }

    public static void printLog() {
        System.out.println(getLog());
    }

    public static void dispose() {
        box.dispose();
        ball.dispose();
    }

    public static String getLog() {
        return fileHandle.readString();
    }
}
