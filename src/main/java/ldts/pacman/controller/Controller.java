package ldts.pacman.controller;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.sound.SoundObserver;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    private List<SoundObserver> observers = new ArrayList<>();
    public Controller(T model) {this.model = model;}
    public T getModel() {
        return model;
    }
//We need to refactor this
    public abstract void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException;
    public void addObserver(SoundObserver observer){
        observers.add(observer);
    }
    public void removeObserver(SoundObserver observer){
        observers.remove(observer);
    }
    public void removeObservers(){observers.clear();}
    public void playSingleSound(SoundObserver observer) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        addObserver(observer);notifyObservers();removeObserver(observer);
    }
    public void notifyObservers() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for(SoundObserver observer : observers){
            observer.onSoundEvent();
        }
    }
}
