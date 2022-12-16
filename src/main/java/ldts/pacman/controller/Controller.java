package ldts.pacman.controller;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.sound.observer.SoundObserver;
import ldts.pacman.sound.subject.SoundSubject;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.ArrayList;
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
//We need to refactor this
    public abstract void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException;
}
