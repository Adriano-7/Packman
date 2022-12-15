package ldts.pacman.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class SoundObserver<T> {
    private final T model;

    public SoundObserver(T model) {
        this.model = model;
    }

    public T getModel() {return model;}
    public abstract void onSoundEvent() throws UnsupportedAudioFileException, LineUnavailableException, IOException;

    protected void playSound(String soundPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundPath));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(0);
    }

}
