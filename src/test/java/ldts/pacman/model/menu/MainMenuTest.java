package ldts.pacman.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuTest {
    private MainMenu mainMenu;
    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
    }
    @Test
    public void testNext_Op() {
        mainMenu.next_Op();
        assertEquals(true, mainMenu.isSelected(1));
    }
    @Test
    public void testPrev_Op() {
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
    public void testIsSelectedExit() {
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
