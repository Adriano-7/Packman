package ldts.pacman.model.game.arena;

import ldts.pacman.sound.observer.SoundPacDies;
import ldts.pacman.sound.observer.SoundStartLevel;
import ldts.pacman.sound.subject.SoundSubject;
import org.junit.jupiter.api.BeforeEach;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaLoaderMultiplayerTest {
    private Arena arena;
    @BeforeEach
    public void setUp() {
        try {
            ArenaLoader arenaLoader = new ArenaLoaderMultiplayer();
            arenaLoader.setLevelNumber(1);
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
