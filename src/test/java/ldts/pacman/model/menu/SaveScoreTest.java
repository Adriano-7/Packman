package ldts.pacman.model.menu;

import ldts.pacman.model.menu.options.SaveScore;
import ldts.pacman.sound.SoundSelection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SaveScoreTest {
    private SaveScore saveScore;
    private SoundSelection soundSelection;
    @BeforeEach
    public void setUp() {
        this.soundSelection = Mockito.mock(SoundSelection.class);
        this.saveScore = new SaveScore(soundSelection, 100);
    }
    @Test
    public void getters() {
        int expectedSizeOfTimeStamp = 5;

        assertEquals(100, saveScore.getScore());
        assertEquals(expectedSizeOfTimeStamp, saveScore.getTimeStamp().length());
    }
    @Test
    public void getNumberEntries() {
        assertEquals(2, saveScore.getNumberEntries());
    }
    @Test
    public void isSelectedSave() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        assertTrue(saveScore.isSelectedSave());

        saveScore.next_Op();

        assertFalse(saveScore.isSelectedSave());

        saveScore.next_Op();

        assertTrue(saveScore.isSelectedSave());
    }
}
