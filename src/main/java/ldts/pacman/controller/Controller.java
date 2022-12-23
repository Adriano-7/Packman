package ldts.pacman.controller;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model) {
        this.model = model;
    }
    public T getModel() {
        return model;
    }
    public abstract void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException;
}
