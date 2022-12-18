package ldts.pacman.model.menu;

import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SaveScore extends Menu {
    private final int score;
    private final String timeStamp;
    public SaveScore(SoundSelection soundSelection, int score) {
        super(soundSelection);
        this.score = score;
        this.timeStamp = new SimpleDateFormat("dd/MM").format(new Date());
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
