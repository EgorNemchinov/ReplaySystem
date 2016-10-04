package com.jacktheogre.replay.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;
import com.jacktheogre.replay.Commands.Command;
import com.jacktheogre.replay.Objects.Ball;

/**
 * Created by luna on 04.10.16.
 */
public class GameWorld {

    private Ball ball;
    private Queue<Command> commands;

    public GameWorld() {
        ball = new Ball(10, 10);
        commands = new Queue<Command>();
    }

    public void update(float delta) {
//        Gdx.app.log("GameWorld", "update");
        executeCommands();
        ball.update(delta);
    }

    private void executeCommands() {
        for (int i = 0; i < commands.size; i++) {
            commands.get(i).execute(ball);
            commands.removeIndex(i);
        }
    }

    public Ball getBall() {
        return ball;
    }

    public void addCommand(Command command) {
        commands.addLast(command);
    }
    //mb array of GameActors to pass in WorldRenderer
}
