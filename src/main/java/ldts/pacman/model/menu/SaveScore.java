package ldts.pacman.model.menu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SaveScore {
    private final int score;
    private final String timeStamp;
    public SaveScore(int score) {
        this.score = score;
        this.timeStamp = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date());
    }
    public int getScore() {
        return score;
    }
    public String getTimeStamp() {
        return timeStamp;
    }
}
