package ldts.pacman.sound.observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoundMenu extends SoundObserver{
    @Override
    public void onSoundEvent() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        playLoopSound("src/main/resources/sounds/pacmanSong.wav");
    }
}

