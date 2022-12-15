package ldts.pacman.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        mainMenu.next_Op();
        assertEquals(true, mainMenu.isSelected(1));
    }
    @Test
    public void testPrev_Op() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        mainMenu.prev_Op();
        assertEquals(true, mainMenu.isSelected(4));
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
    public void testIsSelectedStart() {
        boolean selected = mainMenu.isSelectedStart();
        assertTrue(selected);
    }
    @Test
    public void testIsSelectedExit() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        mainMenu.next_Op();mainMenu.next_Op();mainMenu.next_Op();mainMenu.next_Op();
        assertTrue(mainMenu.isSelectedExit());
        mainMenu.next_Op();
        assertFalse(mainMenu.isSelectedExit());
    }
    @Test
    public void testGetNumberEntries() {
        int number = mainMenu.getNumberEntries();
        assertEquals(5, number);
    }
}
