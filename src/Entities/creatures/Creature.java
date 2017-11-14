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
            } else {
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }


        } else if (xMove < 0) {//moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

            //equation will get the uper right corner of the bounding box
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_hEIGHT)
                    && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_hEIGHT)) {
                x += xMove;
            } else {

                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    public void moveY() {

        if (yMove > 0) {//moving  up
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_hEIGHT;

            if (!collisionWithTile(ty, (int) (x + bounds.x) / Tile.TILE_WIDTH)
                    && !collisionWithTile(ty, (int) (x + bounds.x + bounds.height) / Tile.TILE_WIDTH)) {
                y += yMove;
            } else {

           //     y = ty * Tile.TILE_hEIGHT + Tile.TILE_hEIGHT - bounds.y;

            }
        }

        if (yMove < 0) {//moving  down
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_hEIGHT;

            if (!collisionWithTile(ty, (int) (x + bounds.x) / Tile.TILE_WIDTH)
                    && !collisionWithTile(ty, (int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH)) {
                y += yMove;
            } else {

            //    y = ty * Tile.TILE_hEIGHT - bounds.y - bounds.height - 1;

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
