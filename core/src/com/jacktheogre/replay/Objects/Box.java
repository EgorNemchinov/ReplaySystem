package com.jacktheogre.replay.Objects;

/**
 * Created by luna on 05.10.16.
 */
public class Box extends GameActor{

    private static int WIDTH = 60;
    private static int HEIGHT = 60;
    private static int SPEED = 90;

    public Box(int x, int y) {
        super(x, y);
        width = WIDTH;
        height = HEIGHT;
        max_speed = SPEED;
    }

    @Override
    public String toString() {
        return "bo";
    }
}
