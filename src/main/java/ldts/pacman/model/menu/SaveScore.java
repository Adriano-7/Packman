package ldts.pacman.model.menu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SaveScore {
    private final int score;
    private final String timeStamp;
    private final List<String> options;
    private int currentOption = 0;
    public SaveScore(int score) {
        this.score = score;
        this.timeStamp = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date());
        this.options = Arrays.asList("SAVE SCORE", "QUIT");
    }
    public int getScore() {
        return score;
    }
    public String getTimeStamp() {
        return timeStamp;
    }

    public void next_Op(){
        currentOption = (currentOption + 1) % options.size();
    }
    public void prev_Op(){currentOption--; if (currentOption < 0) currentOption = this.options.size() - 1;}
    public String getOption(int i){
        return this.options.get(i);
    }
    public boolean isSelectedSave(){
        return  currentOption==0;
    }
    public boolean isSelectedExit(){
        return currentOption==1;
    }
    public int getNumberEntries(){
        return options.size();
    }
    public boolean isSelected(int i){
        return currentOption == i;
    }
}