package com.jacktheogre.replay.Objects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by luna on 04.10.16.
 */
public class Entity {
    protected Vector2 position;
    protected Vector2 velocity;
    protected int width,
                height;

    public Entity(int x, int y) {
        this.position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
