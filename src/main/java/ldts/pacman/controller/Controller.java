package ldts.pacman.controller;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import java.util.List;
import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, List<GUI.OPTION> options, long time) throws IOException;
}
