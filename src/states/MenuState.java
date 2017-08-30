package states;

import gfx.Assets;

import java.awt.*;

public class MenuState extends State {


    public MenuState() {
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerstatic3, 0, 0, null);
    }
}
