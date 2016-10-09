package com.jacktheogre.replay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.StringBuilder;
import com.jacktheogre.replay.Commands.MoveCommand;
import com.jacktheogre.replay.GameWorld.GameWorld;
import com.jacktheogre.replay.Objects.Ball;

/**
 * Created by luna on 04.10.16.
 */
public class InputHandler implements InputProcessor {

    private StringBuilder sb;
    private Ball ball;
    private GameWorld gameWorld;
    public float runTIme;

    public InputHandler(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        sb = new StringBuilder();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(gameWorld.state == GameWorld.GameState.RUN) {
            gameWorld.addCommand(new MoveCommand(screenX - gameWorld.getActor().getWidth() / 2, screenY - gameWorld.getActor().getHeight() / 2));
            sb.setLength(0);
            sb.append("m ").append(gameWorld.getActor()).append(" ").append((int) screenX - gameWorld.getActor().getWidth() / 2).append(" ").
                    append((int)screenY - gameWorld.getActor().getHeight() / 2).append(" ").append(gameWorld.getRunTime()).append("\n");
            AssetLoader.logString(sb.toString());
            gameWorld.setNewCommands(true);
            return true;
        } else return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(gameWorld.state == GameWorld.GameState.RUN) {
            sb.setLength(0);
            if (keycode == Input.Keys.SPACE) {
                gameWorld.changeActor();
                sb.append("s ").append(gameWorld.getRunTime()).append("\n");
                AssetLoader.logString(sb.toString());
            }
            if (keycode == Input.Keys.U) {
                if (gameWorld.undo()) {
                    Gdx.app.log("GameWorld", "Undone");
                    sb.append("u ").append(gameWorld.getRunTime()).append("\n");
                    AssetLoader.logString(sb.toString());
                }
            }
            if (keycode == Input.Keys.R) {
                if (gameWorld.redo()) {
                    Gdx.app.log("GameWorld", "Redone");
                    sb.append("r ").append(gameWorld.getRunTime()).append("\n");
                    AssetLoader.logString(sb.toString());
                }
            }
            return true;
        } else return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
