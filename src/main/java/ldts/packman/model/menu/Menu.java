package ldts.packman.model.menu;

import java.util.Arrays;
import java.util.List;
public class Menu {
    private final List<String> options;
    private int currentoption=0;
    public Menu(){
        this.options=Arrays.asList("Start","Exit","Rules","Settings","Credits","Scores","Single player","Multiplayer"); // Multi e single player depende do Start
    }
    public void next_Op(){
        currentoption++;
        if(currentoption>this.options.size()-1)
            currentoption=0;

    }
    public void prev_Op(){
        currentoption--;
        if(currentoption<0)
            currentoption=this.options.size() -1;
    }
    public String getOption(int i){
        return this.options.get(i);
    }

    public boolean isSelected(int i) {
        return currentoption == i;
    }
    public void isSelectedGoBack(){
        if(isSelectedStart())
            currentoption--;
    }
    public boolean isSelectedStart(){
        return isSelected(0);
    }
    public boolean isSelectedExit() {
            return isSelected(1);
    }
    public boolean isSelectedRules(){
        return isSelected(2);
    }
    public boolean isSelectedSettings(){
        return isSelected(3);
    }
    public boolean isSelectedCredits(){
        return isSelected(4);
    }
    public boolean isSelectedScores(){
        return isSelected(5);
    }
}
