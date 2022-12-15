package ldts.pacman.sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoundPacDies extends SoundObserver{
    public SoundPacDies() {;}
    @Override
    public void onSoundEvent() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        playSingleSound("src/main/resources/sounds/pacDeath.wav");
    }
}
