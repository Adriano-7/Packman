package ldts.pacman.model.menu;

import java.util.Arrays;
import java.util.List;

public class ChooseLevel extends Menu {
    @Override
    protected List<String> createOptions() {
        return Arrays.asList("LEVEL 1", "LEVEL 2", "LEVEL 3", "EXIT");
    }
    public boolean isSelectedExit(){
        return isSelected(3);
    }
}
