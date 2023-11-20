package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdoutView implements DrawNumberView {

    private static final String NEW_GAME = ": a new game starts!";

    @Override
    public void setController(DrawNumberController observer) {
    }

    @Override
    public void start() {
        System.out.println("Draw Number game");
    }

    @Override
    public void result(DrawResult res) {
        switch (res) {
            case YOURS_HIGH, YOURS_LOW:
                System.out.println(res.getDescription());
                break;
            case YOU_WON:
                System.out.println(res.getDescription() + NEW_GAME);
                break;
            case YOU_LOST:
                System.out.println(res.getDescription() + NEW_GAME);
                break;
            default:
                throw new IllegalStateException("Unknown game state");
        }
    }
}
