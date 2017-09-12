package states;

import Entities.creatures.Player;
import Worlds.World;
import main.Game;
import main.Handler;
import tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;


    public GameState(Handler handler) {
        super(handler);


        world = new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);
        player = new Player(handler,100,100);
    }


    @Override
    public void tick() {
        world.tick();
        player.tick();
    }


    //this method renders all the things
    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);

    }
}
