package ldts.pacman.model.menu;

import java.util.Arrays;
import java.util.List;
public class Menu {
    private final List<String> options;
    private int currentoption=0;
    public Menu(){
        this.options= Arrays.asList("SINGLE PLAYER","MULTIPLAYER","SCORES","OPTIONS" ,"EXIT");
    }

    public void next_Op(){
        currentoption = (currentoption + 1) % options.size();
    }
    public void prev_Op(){
        currentoption = (currentoption - 1) % options.size();
    }
    public String getOption(int i){
        return this.options.get(i);
    }
    public boolean isSelected(int i){
        return currentoption == i;
    }
    public void isSelectedGoBack(){
        if(isSelectedStart())
            currentoption--;
    }
    public boolean isSelectedStart(){
        return isSelected(0);
    }
    public boolean isSelectedExit(){
        return isSelected(4);
    }
    public int getNumberEntries(){
        return options.size();
    }


}
