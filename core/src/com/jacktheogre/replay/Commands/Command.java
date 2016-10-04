package com.jacktheogre.replay.Commands;

import com.jacktheogre.replay.Objects.GameActor;

/**
 * Created by luna on 04.10.16.
 */
public abstract class Command {

    public abstract void execute(GameActor actor);
}
