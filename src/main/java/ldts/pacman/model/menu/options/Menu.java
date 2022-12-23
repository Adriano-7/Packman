package ldts.pacman.model.menu.options;

import ldts.pacman.sound.SoundSelection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
public abstract class Menu {
    protected List<String> options;
    protected final SoundSelection soundSelection;
    private int currentOption = 0;
    public Menu(SoundSelection soundSelection) {
        this.options = createOptions();
        this.soundSelection = soundSelection;
    }
    public void next_Op() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        currentOption = (currentOption + 1) % options.size();
        soundSelection.onSoundEvent();
    }
    public void prev_Op() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        currentOption--;
        if (currentOption < 0) currentOption = this.options.size() - 1;
        soundSelection.onSoundEvent();
    }
    public String getOption(int i){
        return this.options.get(i);
    }
    public boolean isSelected(int i){
        return currentOption == i;
    }
    public int getNumberEntries(){
        return options.size();
    }
    public int getCurrentOption() {
        return this.currentOption;
    }
    protected abstract List<String> createOptions();
}
