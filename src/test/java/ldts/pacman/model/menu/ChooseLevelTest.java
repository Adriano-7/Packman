package ldts.pacman.model.menu;

import ldts.pacman.model.game.arena.ArenaLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChooseLevelTest {
    private ArenaLoader arenaLoader;
    private ChooseLevel chooseLevel;
    @BeforeEach
    public void setUp() {
        this.arenaLoader = new ArenaLoader();
        this.chooseLevel = new ChooseLevel(arenaLoader);
    }
    @Test
    public void getArenaLoader() {
        assertEquals(arenaLoader, chooseLevel.getArenaLoader());
    }
    @Test
    public void isSelectedExit() {
        chooseLevel.next_Op(); chooseLevel.next_Op(); chooseLevel.next_Op();
        assertTrue(chooseLevel.isSelectedExit());
    }
    @Test
    public void getNumberEntries() {
        assertEquals(4, chooseLevel.getNumberEntries());
    }
    @Test
    public void isSelectedNext() {
        assertTrue(chooseLevel.isSelected(0));
        chooseLevel.next_Op();
        assertTrue(chooseLevel.isSelected(1));
        chooseLevel.next_Op();
        assertTrue(chooseLevel.isSelected(2));
        chooseLevel.next_Op();
        assertTrue(chooseLevel.isSelected(3));
        chooseLevel.next_Op();
        assertTrue(chooseLevel.isSelected(0));
    }
    @Test
    public void isSelectedPrev() {
        assertTrue(chooseLevel.isSelected(0));
        chooseLevel.prev_Op();
        assertTrue(chooseLevel.isSelected(3));
        chooseLevel.prev_Op();
        assertTrue(chooseLevel.isSelected(2));
        chooseLevel.prev_Op();
        assertTrue(chooseLevel.isSelected(1));
        chooseLevel.prev_Op();
        assertTrue(chooseLevel.isSelected(0));
    }
}
