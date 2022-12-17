package ldts.pacman.model.menu;

import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuTest {
    private MainMenu mainMenu;
    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
    }
    @Test
    public void testNext_Op() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        assertEquals(0, mainMenu.getCurrentOption());
        mainMenu.next_Op();
        assertTrue(mainMenu.isSelected(1));
        assertEquals(1, mainMenu.getCurrentOption());
    }
    @Test
    public void testPrev_Op() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        mainMenu.prev_Op();
        assertTrue(mainMenu.isSelected(3));
    }
    @Test
    public void testGetOption() {
        String option = mainMenu.getOption(0);
        assertEquals("SINGLE PLAYER", option);
    }
    @Test
    public void testIsSelected() {
        boolean selected = mainMenu.isSelected(0);
        assertTrue(selected);
    }
    @Test
    public void testIsSelectedStartSingle() {
        boolean selected = mainMenu.isSelectedStartSingle();
        assertTrue(selected);
    }
    @Test
    public void testIsSelectedStartMulti() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        mainMenu.next_Op();
        boolean selected = mainMenu.isSelectedStartMulti();
        assertTrue(selected);
    }
    @Test
    public void isSelectedScores() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        mainMenu.next_Op();mainMenu.next_Op();
        assertTrue(mainMenu.isSelectedScores());

        mainMenu.next_Op();
        assertFalse(mainMenu.isSelectedScores());
    }
    @Test
    public void testIsSelectedExit() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        mainMenu.next_Op();mainMenu.next_Op();mainMenu.next_Op();
        assertTrue(mainMenu.isSelectedExit());
        mainMenu.next_Op();
        assertFalse(mainMenu.isSelectedExit());
    }
    @Test
    public void testGetNumberEntries() {
        int number = mainMenu.getNumberEntries();
        assertEquals(4, number);
    }
}
