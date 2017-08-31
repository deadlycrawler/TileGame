package Entities.creatures;

import gfx.Assets;
import main.Game;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        //the size entered
        super(x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }


    @Override
    public void tick() {
        if (game.getKeyManager().up) y -= 6;
        if (game.getKeyManager().down) y += 6;
        if (game.getKeyManager().left) x -= 6;
        if (game.getKeyManager().right) x += 6;

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.playerstatic1, (int) x, (int) y, width, height, null);

    }
}
