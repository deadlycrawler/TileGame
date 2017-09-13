package Entities.creatures;

import Entities.Entity;
import main.Game;
import main.Handler;
import tiles.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 90;
    public static final int DEFAULT_CREATURE_HEIGHT = 115;

    //PlayerWidth = 90, PlayerHeight =115


    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;


    }

    public void move() {
        moveX();
        moveY();

    }

    public void moveX() {

        if (xMove > 0) {//moving  right
            //tile location for collision detection
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;

            //equation will get the uper right corner of the bounding box, and then adding the bounds.height adds the bottom right corner
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_hEIGHT)
                    && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_hEIGHT)) {
                x += xMove;
            }


        } else if (xMove < 0) {//moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

            //equation will get the uper right corner of the bounding box
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_hEIGHT)
                    && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_hEIGHT)) {
                x += xMove;
            }
        }
    }

    public void moveY() {

        if (yMove > 0) {//moving  up
            int tx = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_hEIGHT;

            if (!collisionWithTile(tx, (int) (x + bounds.x) / Tile.TILE_WIDTH)
                    && !collisionWithTile(tx, (int) (x + bounds.x + bounds.height) / Tile.TILE_WIDTH)) {
                y += yMove;
            }
        }

        if (yMove < 0) {//moving  down
            int tx = (int) (y + yMove + bounds.y) / Tile.TILE_hEIGHT;

            if (!collisionWithTile(tx, (int) (x + bounds.x) / Tile.TILE_WIDTH)
                    && !collisionWithTile(tx, (int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH)) {
                y += yMove;
            }
        }

    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();

    }


    //GETTERS AND SETTERS
    public static int getDefaultHealth() {
        return DEFAULT_HEALTH;
    }

    public static float getDefaultSpeed() {
        return DEFAULT_SPEED;
    }

    public void setDefaultHealth(int health) {
        this.health = health;
    }

    public void setDefaultSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
