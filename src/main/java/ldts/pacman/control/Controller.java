package ldts.pacman.control;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.OPTION option, long time);
}
