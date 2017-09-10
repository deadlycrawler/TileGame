package states;

import Entities.creatures.Player;
import Worlds.World;
import main.Game;
import tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;


    public GameState(Game game) {
        super(game);

        player = new Player(game,100,100);
        world = new World("res/worlds/world1.txt");
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
