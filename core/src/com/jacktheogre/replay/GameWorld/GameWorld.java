package com.jacktheogre.replay.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Queue;
import com.jacktheogre.replay.Commands.Command;
import com.jacktheogre.replay.Objects.Ball;
import com.jacktheogre.replay.Objects.Box;
import com.jacktheogre.replay.Objects.GameActor;
import com.jacktheogre.replay.ReplayBall;

import java.util.Stack;

/**
 * Created by luna on 04.10.16.
 */
public class GameWorld {

    private GameActor currentActor;
    private Ball ball;
    private Box box;
    private Stack<Command> commands;
    private int pointer = 0;
    private boolean newCommands;

    public GameWorld() {
        ball = new Ball(10, 10);
        box = new Box(ReplayBall.WIDTH - 10, 10);
        currentActor = box;
        newCommands = false;

        commands = new Stack<Command>();
//        allCommands = new List<Command>();
    }

    public void update(float delta) {
//        Gdx.app.log("GameWorld", "update");
        if(newCommands)
            executeCommands();
        ball.update(delta);
        box.update(delta);
    }

    public boolean undo() {
        if(pointer >= 1) {
            pointer--;
            commands.get(pointer).undo();
            return true;
        } else
            return false;
    }

    public boolean redo() {
        if(pointer < commands.size()) {
            commands.get(pointer).redo();
            pointer++;
            return true;
        } else
            return false;
    }

    private void executeCommands() {
        for (int i = pointer; i < commands.size(); i++) {
            /*if(!commands.get(i).execute(currentActor))
                break;*/
            commands.get(i).execute(currentActor);
            Gdx.app.log("GameWorld", curActor() + " moved");
        }
        if(commands.size() > 0)
            pointer = commands.size();
        newCommands = false;
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
        for (int i = 0; i < (commands.size() - pointer); i++) { //mb linkedlist to do it faster
            commands.pop();
        }
        commands.push(command);
    }

    public void setNewCommands(boolean newCommands) {
        this.newCommands = newCommands;
    }

    //mb array of GameActors to pass in WorldRenderer
}
