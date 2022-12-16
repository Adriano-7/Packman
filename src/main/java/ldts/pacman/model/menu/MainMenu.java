package ldts.pacman.model.menu;

import ldts.pacman.sound.observer.SoundSelection;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {
    @Override
    protected List<String> createOptions() {
        return Arrays.asList("SINGLE PLAYER","MULTIPLAYER","SCORES","EXIT");
    }
    public boolean isSelectedStartSingle(){
        return isSelected(0);
    }
    public boolean isSelectedStartMulti() {
        return isSelected(1);
    }
    public boolean isSelectedExit(){
        return isSelected(3);
    }
    public boolean isSelectedScores() {
        return isSelected(2);
    }
}
