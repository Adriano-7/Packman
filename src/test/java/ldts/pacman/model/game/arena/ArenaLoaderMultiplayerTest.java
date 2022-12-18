package ldts.pacman.model.game.arena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaLoaderMultiplayerTest {
    private Arena arena;
    @BeforeEach
    public void setUp() {
        try {
            ArenaLoader arenaLoader = new ArenaLoaderMultiplayer();
            arenaLoader.setLevelNumber(3);

            this.arena = arenaLoader.createArena();
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
    }

    @Test
    public void arenaElements() {
        assertEquals(5, arena.getMonsters().size());
        assertTrue(arena.getPowerUps().size() > 0);
        assertTrue(arena.getCoins().size() > 0);
        assertTrue(arena.getWalls().size() > 0);
    }
}
