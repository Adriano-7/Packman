package ldts.pacman.model.menu;

import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.observer.SoundStartLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ChooseLevelTest {
    private ArenaLoader arenaLoader;
    private ChooseLevel chooseLevel;
    private SoundSelection soundSelection;
    @BeforeEach
    public void setUp() {
        this.arenaLoader = Mockito.mock(ArenaLoader.class);
        this.soundSelection = Mockito.mock(SoundSelection.class);

        this.chooseLevel = new ChooseLevel(soundSelection, arenaLoader);
    }
    @Test
    public void getArenaLoader() {
        assertEquals(arenaLoader, chooseLevel.getArenaLoader());
    }
    @Test
    public void isSelectedExit() {
        try {
            chooseLevel.next_Op();
            chooseLevel.next_Op();
            chooseLevel.next_Op();
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        assertTrue(chooseLevel.isSelectedExit());
    }
    @Test
    public void getNumberEntries() {
        assertEquals(4, chooseLevel.getNumberEntries());
    }
    @Test
    public void isSelectedNext() {
        try {
            assertTrue(chooseLevel.isSelected(0));
            chooseLevel.next_Op();
            assertTrue(chooseLevel.isSelected(1));
            chooseLevel.next_Op();
            assertTrue(chooseLevel.isSelected(2));
            chooseLevel.next_Op();
            assertTrue(chooseLevel.isSelected(3));
            chooseLevel.next_Op();
            assertTrue(chooseLevel.isSelected(0));
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
    }
    @Test
    public void isSelectedPrev() {
        try {
            assertTrue(chooseLevel.isSelected(0));
            chooseLevel.prev_Op();
            assertTrue(chooseLevel.isSelected(3));
            chooseLevel.prev_Op();
            assertTrue(chooseLevel.isSelected(2));
            chooseLevel.prev_Op();
            assertTrue(chooseLevel.isSelected(1));
            chooseLevel.prev_Op();
            assertTrue(chooseLevel.isSelected(0));
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
    }
}
