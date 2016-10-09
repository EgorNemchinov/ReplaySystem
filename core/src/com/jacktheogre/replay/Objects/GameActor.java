package com.jacktheogre.replay.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by luna on 04.10.16.
 */
public class GameActor extends Entity {

    private static final float FAULT = 2;
    public float max_speed;
    private int destinX, destinY;
    private float velX, velY;
    private int sideX, sideY;
    private boolean newVelocity;

    public GameActor(int x, int y) {
        super(x, y);
        max_speed = 0;
        newVelocity = false;
        destinX = x;
        destinY = y;
    }

    public void update(float dt) {
        calcVelocity();
//        Gdx.app.log("GameActor", "velocity is "+ velocity.x + ", " + velocity.y);
//        Gdx.app.log("GameActor", "destination is "+ destinX + ", " + destinY);
        position.add(velocity.cpy().scl(dt));
    }

    public void setVelocity(float x, float y) {
        this.velocity.set(x, y);
    }

    public void setPosition(int x, int y) {
        this.position.set(x,y);
    }

    public void setDestination(int x, int y) {
        destinX = x;
        destinY = y;
        sideX = sideX();
        sideY = sideY();
        newVelocity = false;
    }

    private void calcVelocity() {
        if(sideX == sideX() && sideY == sideY() && newVelocity) {
//            System.out.println("return");
            return;
        }
        if(Math.abs(destinX - getX()) < FAULT && Math.abs(destinY - getY()) < FAULT) {
            velocity.set(0, 0);
            newVelocity = true;
            sideX = 0;
            sideY = 0;
            return;
        }
        if(destinY - getY() == 0) {
            velY = 0;
            velX = (destinX - getX()) < 0 ?  -max_speed : max_speed;
        } else {
            float koef = Math.abs((destinX - getX()) / (destinY - getY()));
            velY = (float) (max_speed / Math.sqrt((1 + koef * koef)));
            velX = velY * koef;
        }
        velocity.set(velX * sideX(), velY * sideY());
        newVelocity = true;
    }

    @Override
    public String toString() {
        return "actor";
    }



    private int sideX() {
        if(Math.abs(destinX - getX()) < FAULT) return 0;
        return destinX < getX() ? -1 : 1;
    }
    private int sideY() {
        if(Math.abs(destinY - getY()) < FAULT) return 0;
        return destinY < getY() ? -1 : 1;
    }
}
