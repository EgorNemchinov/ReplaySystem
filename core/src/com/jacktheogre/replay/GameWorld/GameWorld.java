package com.jacktheogre.replay.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;
import com.jacktheogre.replay.Commands.Command;
import com.jacktheogre.replay.Objects.Ball;
import com.jacktheogre.replay.Objects.Box;
import com.jacktheogre.replay.Objects.GameActor;
import com.jacktheogre.replay.ReplayBall;

/**
 * Created by luna on 04.10.16.
 */
public class GameWorld {

    private GameActor currentActor;
    private Ball ball;
    private Box box;
    private Queue<Command> commands;

    public GameWorld() {
        ball = new Ball(10, 10);
        box = new Box(ReplayBall.WIDTH - 10, 10);
        currentActor = box;
        ;
        commands = new Queue<Command>();
    }

    public void update(float delta) {
//        Gdx.app.log("GameWorld", "update");
        executeCommands();
        ball.update(delta);
        box.update(delta);
    }

    private void executeCommands() {
        for (int i = 0; i < commands.size; i++) {
            commands.get(i).execute(currentActor);
            commands.removeIndex(i);
            Gdx.app.log("GameWorld", curActor() + " moved");
        }
    }

    public void changeActor() {
        if(currentActor == ball) {
            currentActor = box;
        } else
            currentActor = ball; // TODO: 05.10.16 change movespeeds or whatever
    }

    public Ball getBall() {
        return ball;
    }

    public Box getBox() {
        return box;
    }

    public GameActor getActor() {
        return currentActor;
    }

    public String curActor() {
        return currentActor == ball ? "ball" : "box";
    }

    public void addCommand(Command command) {
        commands.addLast(command);
    }
    //mb array of GameActors to pass in WorldRenderer
}
