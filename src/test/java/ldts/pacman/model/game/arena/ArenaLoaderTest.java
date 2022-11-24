package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ArenaLoaderTest {
    private Arena arena;
    @BeforeEach
    public void setUp() {
        try {
            ArenaLoader arenaLoader = new ArenaLoader(1);
            this.arena = arenaLoader.createArena();
        }
        catch (IOException e) {
            fail();
        }
    }
    @Test
    public void pacman() {
        assertEquals(new Position(2, 2), arena.getPacman().getPosition());
    }
}
