package ldts.pacman.sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoundPacCoin extends Sound {
    @Override
    public void onSoundEvent() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        playSingleSound("src/main/resources/sounds/pacCoin.wav");
    }
}
