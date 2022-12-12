package ldts.pacman.model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {
    @Override
    protected List<String> createOptions() {
        return Arrays.asList("SINGLE PLAYER","MULTIPLAYER","SCORES","OPTIONS","EXIT");
    }
    public boolean isSelectedStart(){
        return isSelected(0) || isSelected(1);
    }
    public boolean isSelectedExit(){
        return isSelected(4);
    }
    public boolean isSelectedScores() {
        return isSelected(2);
    }
}
