package com.jacktheogre.replay;

import com.badlogic.gdx.Gdx;
import com.jacktheogre.replay.GameWorld.GameWorld;

/**
 * Created by luna on 08.10.16.
 */
public class Enterpreter {

    private GameWorld gameWorld;
    private String[] strings;
    private Action[] actions;
    private int pointer;
    private float runTime;

    public Enterpreter(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
//        load();
//        System.out.println("Size of strings is "+strings.length);
    }

    public void load() {
        this.strings = AssetLoader.getLog().split("\n");
        this.actions = new Action[strings.length];
        for (int i = 0; i < strings.length; i++) {
            actions[i] = new Action(strings[i], gameWorld);
        }
        pointer = 0;
        runTime = gameWorld.getRunTime();
        Gdx.app.log("Enterpreter", "Loaded. Actions size is " + actions.length);
    }

    public void update(float dt) {
        runTime += dt;

//        Gdx.app.log("Enterpreter", "time is "+runTime);
        /*for (int i = 0; i < actions.length; i++) {
            Gdx.app.log("Enterpreter", actions[i].getTime()+"");
        }*/
        while(pointer < actions.length && actions[pointer].getTime() < runTime) {
            actions[pointer].execute();
            pointer++;
//            Gdx.app.log("Enterpreter", pointer + " - pointer.");
        }
    }


}
