package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaLoaderTest {
    private Arena arena;
    @BeforeEach
    public void setUp() {
        try {
            ArenaLoader arenaLoader = new ArenaLoader();
            arenaLoader.setLevelNumber(3);
            this.arena = arenaLoader.createArena();
        }
        catch (IOException e) {
            fail();
        }
    }
    @Test
    public void arenaElements() {
        //assertEquals(new Position(2, 2), arena.getPacman().getPosition());
        assertTrue(arena.getMonsters().size() > 0);
        assertTrue(arena.getPowerUps().size() > 0);
        assertTrue(arena.getCoins().size() > 0);
        assertTrue(arena.getWalls().size() > 0);
    }
}
