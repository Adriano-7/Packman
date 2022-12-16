package ldts.pacman.model.menu;

import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveScoreTest {
    private SaveScore saveScore;
    private SoundSelection soundSelection;
    private SoundSubject soundSubject;
    @BeforeEach
    public void setUp() {
        this.soundSelection = Mockito.mock(SoundSelection.class);
        this.soundSubject = Mockito.mock(SoundSubject.class);
        this.saveScore = new SaveScore(soundSelection, soundSubject,100);
    }
    @Test
    public void getters() {

        int expectedSizeOfTimeStamp = 5;

        assertEquals(100, saveScore.getScore());
        assertEquals(expectedSizeOfTimeStamp, saveScore.getTimeStamp().length());
    }
}
