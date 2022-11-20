package ldts.pacman.model.game.arena;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTest {
    @Test
    public void getters() {
        Arena arena = new Arena(10, 20);

        assertEquals(10, arena.getWidth());
        assertEquals(20, arena.getHeight());
    }
}
