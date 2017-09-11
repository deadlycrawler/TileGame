package gfx;

import Entities.Entity;
import main.Game;

public class GameCamera {
    private float xOffset, yOffset;
    private Game game;

    public GameCamera(Game game, float xOffset, float yOffset) {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;

    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getX()-game.getWidth()/2+ entity.getWidth()/2;
        yOffset = entity.getY()-game.getHeight()/2+entity.getHeight()/2;

    }

    //Amt=amount
    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;

    }


    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
