package states;

import gfx.Assets;
import main.Game;
import main.Handler;

import java.awt.*;

public class MenuState extends State {


    public MenuState(Handler handler) {
        super(handler);

    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerstatic3, 0, 0, null);
    }
}
