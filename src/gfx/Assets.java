package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    //player size x=120,y=115, actualy x size = 90, 120 is the offset between different frames
    //row 1 starts at y15


    private static final int PlayerWidth = 90, PlayerHeight =115,PlayerOffsetX=120,PlayerSartingX=10;
    private static final int TILE_WIDTH=64,TILE_HEIGHT=64,TILE_OFFSET=64,TILE_STARTING_X=0,TILE_sTARTING_Y=0;




    //idle player animation
    public static BufferedImage playerstatic1,playerstatic2,playerstatic3;

    //grass tiles
    public static BufferedImage grass1,grass1_shadow,grass2,grass2_shadow,grass3_shawdow,grass4,grass4_shadow;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/link.png"));
        SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));

        //player sprites
        //player idle
        playerstatic1 = sheet.crop(PlayerSartingX,15, PlayerWidth, PlayerHeight);
        playerstatic2 = sheet.crop(PlayerSartingX+PlayerOffsetX,15, PlayerWidth, PlayerHeight);
        playerstatic3 = sheet.crop(PlayerSartingX+(PlayerOffsetX*2),15, PlayerWidth, PlayerHeight);





        //tile sprites
        //grass
        grass1 = tiles.crop(TILE_STARTING_X,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);

        grass2 = tiles.crop(TILE_STARTING_X+TILE_OFFSET*2,TILE_sTARTING_Y+TILE_OFFSET*2,TILE_WIDTH,TILE_HEIGHT);


    }

}
