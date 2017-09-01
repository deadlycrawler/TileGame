package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    //player size x=120,y=115, actualy x size = 90, 120 is the offset between different frames
    //row 1 starts at y15


    private static final int PlayerWidth = 90, PlayerHeight =115,PlayerOffsetX=120,PlayerSartingX=10;
    private static final int TILE_WIDTH=64,TILE_HEIGHT=64,TILE_OFFSET=64,TILE_STARTING_X=0,TILE_sTARTING_Y=0;




    //idle player animation
    public static BufferedImage playerstatic1,playerstatic2,playerstatic3;

    //stone tiles
    public static BufferedImage stone1;

    //sand tiles
    public static BufferedImage sand1;

    //grass tiles
    public static BufferedImage grass1,grass1_shadow,grass2,grass2_shadow,grass3,grass3_shadow,grass4,grass4_shadow;

    //dirt tiles
    public static BufferedImage dirt1;

    //brick
    public static BufferedImage brick1;


    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/link.png"));
        SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));

        //player sprites
        //player idle
        playerstatic1 = sheet.crop(PlayerSartingX,15, PlayerWidth, PlayerHeight);
        playerstatic2 = sheet.crop(PlayerSartingX+PlayerOffsetX,15, PlayerWidth, PlayerHeight);
        playerstatic3 = sheet.crop(PlayerSartingX+(PlayerOffsetX*2),15, PlayerWidth, PlayerHeight);


        //tile sprites
        //stoneWall
        stone1 = tiles.crop(TILE_STARTING_X,TILE_sTARTING_Y,TILE_WIDTH,TILE_HEIGHT);

        //sand
        sand1 = tiles.crop(TILE_STARTING_X,TILE_sTARTING_Y+TILE_OFFSET*1,TILE_WIDTH,TILE_HEIGHT);

        //grass
        grass1 = tiles.crop(TILE_STARTING_X,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);
        grass2 = tiles.crop(TILE_STARTING_X+TILE_OFFSET*2,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);
        grass3 = tiles.crop(TILE_STARTING_X+TILE_OFFSET*4,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);
        grass4 = tiles.crop(TILE_STARTING_X+TILE_OFFSET*6,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);

        //shadow grass
        grass1_shadow = tiles.crop(TILE_STARTING_X+TILE_OFFSET*1,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);
        grass2_shadow = tiles.crop(TILE_STARTING_X+TILE_OFFSET*3,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);
        grass3_shadow = tiles.crop(TILE_STARTING_X+TILE_OFFSET*5,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);
        grass4_shadow = tiles.crop(TILE_STARTING_X+TILE_OFFSET*7,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);

        //dirt tiles
        //dirt
        dirt1 = tiles.crop(TILE_STARTING_X,TILE_sTARTING_Y+TILE_OFFSET*3,TILE_WIDTH,TILE_HEIGHT);

        //brick Tiles
        //brick
        brick1 = tiles.crop(TILE_STARTING_X,TILE_sTARTING_Y*4,TILE_WIDTH,TILE_HEIGHT);




    }

}
