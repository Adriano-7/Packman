package ldts.pacman.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreMenuTest {
    ScoreMenu scoreMenu;
    @BeforeEach
    public void setUp() {
        try {
            scoreMenu = new ScoreMenu();
        }
        catch (IOException e) { fail(); }
    }
    @Test
    public void getLines() {
        List<String> lines = scoreMenu.getLines();
        assertTrue(lines.size() > 0);
    }
    /*
    @Test
    public void addScore() {

    }
    */
}
