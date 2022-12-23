package ldts.pacman.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreMenuTest {
    private ScoreMenu scoreMenu;
    @BeforeEach
    public void setUp() {
        try {
            scoreMenu = new ScoreMenu("/scores.txt");
        }
        catch (IOException e) { fail(); }
    }
    @Test
    public void getLines() {
        List<String> lines = scoreMenu.getLines();
        assertTrue(lines.size() <= 10);
    }
    @Test
    public void addScore() {
        String userName = "25/11";
        int score = 100;
        int beforeSize = scoreMenu.getLines().size();

        assertTrue(beforeSize <= 10);
        try {
            scoreMenu.addScore(userName, score);
        }
        catch (IOException e) { fail(); }

        int afterSize = scoreMenu.getLines().size();

        if (beforeSize == 10) assertEquals(beforeSize, afterSize);
        else assertEquals(beforeSize + 1, afterSize);
    }
    @Test
    public void addScoreZero() {
        String userName = "25/12";
        int score = 0;
        int beforeSize = scoreMenu.getLines().size();

        assertTrue(beforeSize <= 10);
        try {
            scoreMenu.addScore(userName, score);
        }
        catch (IOException e) { fail(); }

        int afterSize = scoreMenu.getLines().size();

        if (beforeSize == 10) assertEquals(beforeSize, afterSize);
        else assertEquals(beforeSize + 1, afterSize);
    }
}
