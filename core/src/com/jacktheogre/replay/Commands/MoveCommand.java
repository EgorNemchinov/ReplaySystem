package com.jacktheogre.replay.Commands;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.jacktheogre.replay.Objects.GameActor;

/**
 * Created by luna on 04.10.16.
 */
public class MoveCommand extends Command {

    private int destinX, destinY;
    private float velX, velY;

    public MoveCommand(int x, int y) {
        destinX = x;
        destinY = y;
    }

    @Override
    public void execute(GameActor actor) {
//        actor.setPosition(destinX, destinY);
        actor.setVelocity(velX, velY);
        actor.setDestination(destinX, destinY);
    }


}
