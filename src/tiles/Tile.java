package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //static vars

    public static Tile[] tiles = new Tile[256];

    public static Tile RockTile = new RockTile(0);
    public static Tile sandTile= new SandTile(1);
    public static Tile grassTile = new GrassTile(2);
    public static Tile dirtTile = new DirtTile(3);
    public static Tile brickTile = new BrickTile(4);



    //class

    public static final int TILE_WIDTH =64,TILE_hEIGHT=64;

    protected BufferedImage texture;
    protected final int id;



    public Tile(BufferedImage texture,  int id){

        this.texture=texture;
        this.id = id;
        tiles[id]=this;
    }

    public void tick(){

    }

    public void render(Graphics g,int x,int y){

        g.drawImage(texture,x,y,TILE_WIDTH,TILE_hEIGHT,null);

    }


    public boolean isSolid(){

        return false;
    }

    //gettters and setters

    public int getId(){

        return id;

    }

}
