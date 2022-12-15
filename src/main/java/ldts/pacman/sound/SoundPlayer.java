package ldts.pacman.sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class SoundPlayer {
    private List<SoundObserver> observers = new ArrayList<>();
    private String currentSong;

    public void addObserver(SoundObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(SoundObserver observer) {
        this.observers.remove(observer);
    }

    public void setSong(String song) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.currentSong = song;
        this.notifyObservers();
    }

    private void notifyObservers() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for (SoundObserver observer : this.observers) {
            observer.onSoundEvent();
        }
    }
}
