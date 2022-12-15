package ldts.pacman.sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoundSelection extends SoundObserver{
    @Override
    public void onSoundEvent() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        playSingleSound("src/main/resources/sounds/MenuSelection.wav");
    }
}
