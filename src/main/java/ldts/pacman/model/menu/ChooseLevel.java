package ldts.pacman.model.menu;

import java.util.Arrays;
import java.util.List;

public class ChooseLevel {
    private final List<String> options;
    private int currentOption = 0;
    public ChooseLevel(){
        this.options = Arrays.asList("LEVEL 1", "LEVEL 2", "LEVEL 3", "EXIT");
    }
    public void next_Op(){
        currentOption = (currentOption + 1) % options.size();
    }
    public void prev_Op(){
        currentOption--;
        if (currentOption < 0) currentOption = this.options.size() - 1;
    }
    public String getOption(int i){
        return this.options.get(i);
    }
    public boolean isSelected(int i){
        return currentOption == i;
    }
    public boolean isSelectedExit(){
        return isSelected(3);
    }
    public int getNumberEntries(){
        return options.size();
    }
    public int getCurrentOption() {
        return currentOption;
    }
}
