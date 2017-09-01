package states;

import Entities.creatures.Player;
import main.Game;
import tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Player player;


    public GameState(Game game) {
        super(game);

        player = new Player(game,100,100);
    }


    @Override
    public void tick() {
        player.tick();
    }


    //this method renders all the things
    @Override
    public void render(Graphics g) {
        player.render(g);
        Tile.tiles[2].render(g,0,0);
        Tile.tiles[1].render(g,64,0);
        Tile.tiles[0].render(g,64*2,0);

    }
}
