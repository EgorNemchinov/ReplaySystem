package com.jacktheogre.replay.Commands;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.jacktheogre.replay.Objects.GameActor;

/**
 * Created by luna on 04.10.16.
 */
public class MoveCommand extends Command {

    private int startX, startY;
    private int destinX, destinY;

    public MoveCommand(int x, int y) {
        destinX = x;
        destinY = y;
        executed = false;
    }

    @Override
    public boolean execute(GameActor actor) {
        if(executed)
            return false;
        this.actor = actor;
        startX = (int) actor.getX();
        startY = (int) actor.getY();
        actor.setDestination(destinX, destinY);
        executed = true;
        Gdx.app.log("MoveCommand", "Done. Moving to " + destinX+", " + destinY + ")");
        return true;
    }

    @Override
    public void undo() {
        actor.setDestination(startX, startY);
        Gdx.app.log("MoveCommand", "Undone. Moving to " + startX+", " + startY + ")");
    }

    @Override
    public void redo() {
        actor.setDestination(destinX, destinY);
        Gdx.app.log("MoveCommand", "Redone. Moving to " + destinX+", " + destinY + ")");
    }

    @Override
    public String toString() {
        return "MoveCommand from (" + startX+", " + startY+") to (" + destinX + ", " + destinY+"). Actor is " + actor;
    }

}
