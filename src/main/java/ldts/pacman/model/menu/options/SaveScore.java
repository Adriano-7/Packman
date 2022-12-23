package ldts.pacman.model.menu.options;

import ldts.pacman.sound.observer.SoundSelection;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class SaveScore extends Menu {
    private final int score;
    private final String timeStamp;
    public SaveScore(SoundSelection soundSelection, int score) {
        super(soundSelection);
        this.score = score;
        this.timeStamp = new SimpleDateFormat("dd/MM").format(Calendar.getInstance().getTime());
    }
    @Override
    protected List<String> createOptions() {
        return Arrays.asList("SAVE SCORE", "QUIT");
    }
    public int getScore() {
        return score;
    }
    public String getTimeStamp() {
        return timeStamp;
    }
    public boolean isSelectedSave(){
        return  isSelected(0);
    }
}
