package com.jacktheogre.replay;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.jacktheogre.replay.Commands.MoveCommand;
import com.jacktheogre.replay.GameWorld.GameWorld;
import com.jacktheogre.replay.Objects.Ball;

/**
 * Created by luna on 04.10.16.
 */
public class InputHandler implements InputProcessor {

    private Ball ball;
    private GameWorld gameWorld;

    public InputHandler(Ball ball, GameWorld gameWorld) {
        this.ball = ball;
        this.gameWorld = gameWorld;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        gameWorld.addCommand(new MoveCommand(screenX - gameWorld.getActor().getWidth() / 2, screenY - gameWorld.getActor().getHeight() / 2));
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.SPACE) gameWorld.changeActor();
        return true;
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
