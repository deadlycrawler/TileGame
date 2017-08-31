package states;

import gfx.Assets;
import main.Game;

import java.awt.*;

public class MenuState extends State {


    public MenuState(Game game) {
        super(game);

    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerstatic3, 0, 0, null);
    }
}
