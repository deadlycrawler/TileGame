package Worlds;

import main.Game;
import tiles.Tile;
import utils.Utils;

import java.awt.*;

public class World {

    private Game game;

    //reference width and height refer to the the number of tiles for the x,y of a square grid type world
    private int width, height;

    //starting player position, variables are set by the 2nd line in the world(1).txt
    private int spawnx, spawny;
    //below array is indexed by x and y cords for the first and second dimensions in the array
    private int[][] tiles;


    public World(Game game, String path) {
        loadWOrld(path);
        this.game = game;


    }

    public void tick() {


    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()), (int) (y * Tile.TILE_hEIGHT - game.getGameCamera().getyOffset()));


            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) return Tile.dirtTile;
        return t;
    }


    private void loadWOrld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnx = Utils.parseInt(tokens[2]);
        spawny = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //+4 is due to the first 4 world numbers being used for player potioin
                tiles[x][y] = Utils.parseInt(tokens[x + y * width + 4]);
            }
        }

    }

}
