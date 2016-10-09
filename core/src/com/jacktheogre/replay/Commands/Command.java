package com.jacktheogre.replay.Commands;

import com.jacktheogre.replay.Objects.GameActor;

/**
 * Created by luna on 04.10.16.
 */
public abstract class Command {
    protected GameActor actor;
    protected boolean executed;

    public abstract boolean execute(GameActor actor);
    public abstract void undo();
    public abstract void redo();

    public void setActor(GameActor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Command. Actor is " + actor;
    }
}
