package com.jacktheogre.replay.Objects;

/**
 * Created by luna on 04.10.16.
 */
public class Ball extends GameActor {

    private static int WIDTH = 50;
    private static int HEIGHT = 50;
    private static int SPEED = 150;

    public Ball(int x, int y) {
        super(x, y);
        width = WIDTH;
        height = HEIGHT;
        max_speed = SPEED;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
    }

    @Override
    public String toString() {
        return "ba";
    }
}
