package Worlds;

import tiles.Tile;

import java.awt.*;

public class World {

    //reference width and height refer to the the number of tiles for the x,y of a square grid type world
    private int width, height;
    //below array is indexed by x and y cords for the first and second dimensions in the array
    private int[][] tiles;


    public World(String path) {
        loadWOrld(path);


    }

    public void tick() {


    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                getTile(x,y).render(g,x*Tile.TILE_WIDTH,y*Tile.TILE_hEIGHT);


            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) return Tile.dirtTile;
        return t;
    }


    private void loadWOrld(String path) {
        //temp
        width = 5;
        height = 5;
        tiles = new int[width][height];

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                tiles[x][y] = 2;
            }
        }

    }

}
