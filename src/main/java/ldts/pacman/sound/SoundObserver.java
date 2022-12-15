package ldts.pacman.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class SoundObserver {
    public abstract void onSoundEvent() throws UnsupportedAudioFileException, LineUnavailableException, IOException;

    protected void playSingleSound(String soundPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundPath));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.setFramePosition(0);
        FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        floatControl.setValue(-10.0f);
        clip.start();
    }

    protected void playLoopSound(String soundPath){

    }

}
