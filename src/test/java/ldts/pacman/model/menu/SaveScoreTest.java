package ldts.pacman.model.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveScoreTest {
    @Test
    public void getters() {
        SaveScore s = new SaveScore(100);
        int expectedSizeOfTimeStamp = 5;

        assertEquals(100, s.getScore());
        assertEquals(expectedSizeOfTimeStamp, s.getTimeStamp().length());
    }
}
