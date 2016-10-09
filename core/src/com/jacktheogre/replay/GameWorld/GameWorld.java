package com.jacktheogre.replay.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Queue;
import com.jacktheogre.replay.Commands.Command;
import com.jacktheogre.replay.Enterpreter;
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
    private float runTime;
    private Enterpreter enterpreter;

    public enum GameState{RUN, REPLAY}
    public GameState state;

    public GameWorld() {
        ball = new Ball(10, 10);
        box = new Box(ReplayBall.WIDTH - 10, 10);
        currentActor = box;
        newCommands = false;
        this.runTime = 0;
        commands = new Stack<Command>();
        state = GameState.RUN;
        enterpreter = new Enterpreter(this);

//        allCommands = new List<Command>();
    }

    public void update(float delta) {
//        Gdx.app.log("GameWorld", "update");
        runTime += delta;


        if(runTime >= ReplayBall.GAME_DURATION) {//RESET
            runTime = 0;
            ball = new Ball(10, 10);
            box = new Box(ReplayBall.WIDTH - 10, 10);
            currentActor = box;
            newCommands = false;
            this.runTime = 0;
            commands = new Stack<Command>();
            pointer = 0;

            if(state == GameState.RUN) {
                state = GameState.REPLAY;
                enterpreter.load();
            }
            else if(state == GameState.REPLAY) {
                state = GameState.RUN;
            }

        }

        if(state == GameState.REPLAY)
            enterpreter.update(delta);

        if(newCommands)
            executeCommands();
        ball.update(delta);
        box.update(delta);
    }

    public boolean undo() {
        if(pointer >= 1) {
            pointer--;
        Gdx.app.log("GameWorld", "Undoing "+commands.get(pointer));
            commands.get(pointer).undo();
            return true;
        } else
            return false;
    }

    public boolean redo() {
        if(pointer < commands.size()) {
            Gdx.app.log("GameWorld", "Redoing "+commands.get(pointer));
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
            if(commands.get(i) != null)
                commands.get(i).execute(currentActor);
//            Gdx.app.log("GameWorld", curActor() + " moved");
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
//        Gdx.app.log("GameWorld","commands size is "+commands.size());
//        if(commands.size()!=0) Gdx.app.log("GameWorld","commands is "+commands.get(0));

    }

    public float getRunTime() {
        return runTime;
    }

    public void setNewCommands(boolean newCommands) {
        this.newCommands = newCommands;
    }

    //mb array of GameActors to pass in WorldRenderer
}
