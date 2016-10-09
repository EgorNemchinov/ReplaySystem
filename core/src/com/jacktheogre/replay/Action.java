package com.jacktheogre.replay;

import com.badlogic.gdx.Gdx;
import com.jacktheogre.replay.Commands.Command;
import com.jacktheogre.replay.Commands.MoveCommand;
import com.jacktheogre.replay.GameWorld.GameWorld;

/**
 * Created by luna on 08.10.16.
 */
public class Action {

    private Command command;
    private String[] arr;
    private float time;
    private GameWorld gameWorld;

    enum ActionType {UNDO, REDO, SWAP, MOVE, NONE};
    private ActionType type = ActionType.NONE;

    public Action(String command, GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        if(command == null || command.length() == 0)
            type = ActionType.NONE;
        else {
            arr = command.split(" ");
            if(command.toCharArray()[0] == 'm') {//собираем команду из строки типа "m actor x y time"
                type = ActionType.MOVE;
                this.command = new MoveCommand(Integer.valueOf(arr[2]), Integer.valueOf(arr[3]));
                if(arr[1].equals("bo")) {
                    this.command.setActor(gameWorld.getBox());
                }
                else if(arr[1].equals("ba")) {
                    this.command.setActor(gameWorld.getBall());
                }
            } else if(command.toCharArray()[0] == 'u') //undo
            {
                type = ActionType.UNDO;
            }
            else if(command.toCharArray()[0] == 'r') {
                Gdx.app.log("Action", command + " - gives redo");
                type = ActionType.REDO;
            }
            else if(command.toCharArray()[0] == 's') {
                type = ActionType.SWAP;
            }
            time = Float.valueOf(arr[arr.length - 1]);
        }
    }

    public void execute() {
//        Gdx.app.log("Action", "executed");
//        System.out.println(type);
        switch (type) {
            case UNDO:
                gameWorld.undo();
                break;
            case REDO:
                gameWorld.redo();
                System.out.println("redone");
                break;
            case SWAP:
                gameWorld.changeActor();
                break;
            case MOVE: {
                System.out.println(command);
                gameWorld.addCommand(command);
                gameWorld.setNewCommands(true);
                break;
            }
        }
    }

//    public String getStr() {
//        return com;
//    }

    public Command getCommand() {
        return command;
    }

    public float getTime() {
        return time;
    }
}
