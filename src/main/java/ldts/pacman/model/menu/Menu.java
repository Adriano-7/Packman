package ldts.pacman.model.menu;

import java.util.List;
public abstract class Menu {
    protected List<String> options;
    private int currentOption = 0;
    public Menu() {
        this.options = createOptions();
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
    public int getNumberEntries(){
        return options.size();
    }
    public int getCurrentOption() {
        return this.currentOption;
    }
    protected abstract List<String> createOptions();
}
