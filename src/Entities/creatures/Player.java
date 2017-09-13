package Entities.creatures;

import gfx.Assets;
import main.Game;
import main.Handler;

import java.awt.*;

public class Player extends Creature {


    public Player(Handler handler, float x, float y) {
        //the size entered
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);


        //this sets the parameters for the bounding box
        //starting position of the bounding box
        bounds.x = 15;
        bounds.y = 70;
        //size of the bounding box
        bounds.width = 60;
        bounds.height = 45;

    }


    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) yMove = -speed;
        if (handler.getKeyManager().down) yMove = speed;
        if (handler.getKeyManager().left) xMove = -speed;
        if (handler.getKeyManager().right) xMove = speed;


    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.playerstatic1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        //test code to draw a bounding box around the players colizion box
//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }
}
