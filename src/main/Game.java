package main;

import Display.Display;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

//this class does a lot

public class Game implements Runnable {

    private Display display;
    private String title;
    private int width;
    private int height;

    private int testx = 0;
    private int testy = 0;
    Integer red,green,blue=00;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;





    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

    }

    //inital run method
    private void init() {

        display = new Display(title, width, height);


    }
    //handles reocuring events
    private void tick() {

    }
    //handles graphic rendering
    private void render() {

        //buffer stregy creats the screen in memory prior to rendering on screen this is used to prevent flickering
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        //g is the object that actly draws to the screen basied on the buffer stragegy frames "draw here"
        g = bs.getDrawGraphics();
        //clears the screen
        g.clearRect(0,0,width,height);
       //draw here





        bs.show();
        //"cleans the paint brush"
        g.dispose();

    }

    @Override
    public void run() {

        init();

        while (running) {
            tick();
            render();
        }
        stop();
    }


    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
