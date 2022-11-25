package ldts.pacman.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    Menu menu;
    @BeforeEach
    public void setUp() {
        menu = new Menu();
    }
    @Test
    public void testNext_Op() {
        menu.next_Op();
        assertEquals(true, menu.isSelected(1));
    }
    @Test
    public void testPrev_Op() {
        menu.prev_Op();
        assertEquals(true, menu.isSelected(4));
    }
    @Test
    public void testGetOption() {
        String option = menu.getOption(0);
        assertEquals("SINGLE PLAYER", option);
    }
    @Test
    public void testIsSelected() {
        boolean selected = menu.isSelected(0);
        assertEquals(true, selected);
    }
    @Test
    public void testIsSelectedStart() {
        boolean selected = menu.isSelectedStart();
        assertEquals(true, selected);
    }
    @Test
    public void testIsSelectedExit() {
        menu.next_Op();menu.next_Op();menu.next_Op();menu.next_Op();
        assertEquals(true, menu.isSelectedExit());
        menu.next_Op();
        assertEquals(false, menu.isSelectedExit());
    }
    @Test
    public void testGetNumberEntries() {
        int number = menu.getNumberEntries();
        assertEquals(5, number);
    }
}
