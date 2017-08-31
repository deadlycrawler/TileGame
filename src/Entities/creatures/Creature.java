package Entities.creatures;

import Entities.Entity;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 90;
    public static final int DEFAULT_CREATURE_HEIGHT = 115;

    //PlayerWidth = 90, PlayerHeight =115


    protected int health;
    protected float speed;
    protected float xMove,yMove;

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
    }


    public static int getDefaultHealth() {
        return DEFAULT_HEALTH;
    }

    public static float getDefaultSpeed() {
        return DEFAULT_SPEED;
    }

    public  void setDefaultHealth(int health) {
        this.health = health;
    }

    public  void setDefaultSpeed(float speed) {
        this.speed = speed;
    }
}
