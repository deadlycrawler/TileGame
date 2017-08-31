package main;

import Display.Display;
import gfx.Assets;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

//this class does a lot

public class Game implements Runnable {

    private Display display;
    private String title;
    private int width;
    private int height;


    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //states
    private State gameState;
    private State menuState;

    //input
    private KeyManager keyManager = new KeyManager();

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

    }

    //inital run method
    private void init() {

        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);


    }

    //handles reocuring events
    private void tick() {
        keyManager.tick();
        if (State.getCurrentState() != null) {
            State.getCurrentState().tick();
        }


    }

    //handles graphic rendering
    private void render() {

        //buffer stregy creats the screen in memory prior to rendering on screen this is used to prevent flickering
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        //g is the object that actly draws to the screen basied on the buffer stragegy frames "draw here"
        g = bs.getDrawGraphics();
        //clears the screen
        g.clearRect(0, 0, width, height);
        //draw here

        if (State.getCurrentState() != null) State.getCurrentState().render(g);


        bs.show();
        //"cleans the paint brush"
        g.dispose();

    }

    @Override
    public void run() {

        init();
        //frames per second
        int fps = 60;
        //1billion, amount of nano seconds in a second, timePerTick is how many nano seconds per frame
        long NanoSecondsInSecond = 1000000000;
        double timePerTick = NanoSecondsInSecond / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();//returns the amound of time in nano seconds
        long timer = 0;
        int ticks = 0;


        while (running) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            //prints frampes perScond into the console
            if (timer >= NanoSecondsInSecond) {
                System.out.println("Ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;

            }
        }
        stop();
    }

    public KeyManager getKeyManager() {

        return keyManager;
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
