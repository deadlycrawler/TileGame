package main;

import Display.Display;

public class Launcher {

    public static void main(String[] args) {

        //contructer varribles, width sets the scrren dim to 16*9
        int height=480;
        int width=height*16/9;
        String title="i love to eat tomamtoes";

        Game game = new Game(title,width,height);
        game.start();
    }

}
