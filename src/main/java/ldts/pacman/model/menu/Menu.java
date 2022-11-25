package ldts.pacman.model.menu;

import java.util.Arrays;
import java.util.List;
public class Menu {
    private final List<String> options;
    private int currentOption =0;
    public Menu(){
        this.options= Arrays.asList("SINGLE PLAYER","MULTIPLAYER","SCORES","OPTIONS", "EXIT");
    }

    public void next_Op(){
        currentOption = (currentOption + 1) % options.size();
    }
    public void prev_Op(){currentOption--; if (currentOption < 0) currentOption = this.options.size() - 1;}
    public String getOption(int i){
        return this.options.get(i);
    }
    public boolean isSelected(int i){
        return currentOption == i;
    }
    public boolean isSelectedStart(){
        return isSelected(0) || isSelected(1);
    }
    public boolean isSelectedExit(){
        return isSelected(4);
    }
    public int getNumberEntries(){
        return options.size();
    }
}
