package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    //player size x=120,y=115, actualy x size = 90, 120 is the offset between different frames
    //row 1 starts at y15


    private static final int PlayerWidth = 90, PlayerHeight =115,PlayerOffsetX=120,PlayerSartingX=10;





    public static BufferedImage playerstatic1,playerstatic2,playerstatic3;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/link.png"));


        playerstatic1 = sheet.crop(PlayerSartingX,15, PlayerWidth, PlayerHeight);
        playerstatic2 = sheet.crop(PlayerSartingX+PlayerOffsetX,15, PlayerWidth, PlayerHeight);
        playerstatic3 = sheet.crop(PlayerSartingX+(PlayerOffsetX*2),15, PlayerWidth, PlayerHeight);

    }

}
