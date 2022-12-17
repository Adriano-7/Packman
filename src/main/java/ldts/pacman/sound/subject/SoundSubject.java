package ldts.pacman.sound.subject;

import ldts.pacman.sound.observer.SoundObserver;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class SoundSubject {
    private List<SoundObserver> observers = new ArrayList<>();

    public void addObserver(SoundObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SoundObserver observer) {
        observers.remove(observer);
    }

    public void playSingleSound(SoundObserver observer) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        addObserver(observer);
        triggerSound();
        removeObserver(observer);
    }

    public void triggerSound() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for (SoundObserver observer : observers) {
            observer.onSoundEvent();
        }
    }
}