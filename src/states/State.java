package states;

import main.Game;
import main.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;


    }

    protected Handler handler;

    public static State getCurrentState() {
        return currentState;
    }
    //class
    protected Game game;

    public State(Handler handler) {

        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
