package ldts.pacman.model.menu;

import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
public abstract class Menu {
    protected List<String> options;
    private int currentOption = 0;
    public Menu() {
        this.options = createOptions();
        soundSelection = new SoundSelection();
        soundSubject = new SoundSubject();
    }
    public void next_Op() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        currentOption = (currentOption + 1) % options.size(); soundSubject.playSingleSound(soundSelection);
    }
    public void prev_Op() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        currentOption--;
        if (currentOption < 0) currentOption = this.options.size() - 1;
        soundSubject.playSingleSound(soundSelection);
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
    private SoundSubject soundSubject;
    protected SoundSelection soundSelection;
}
