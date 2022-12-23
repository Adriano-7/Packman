package ldts.pacman.model.game.arena;

import ldts.pacman.sound.SoundPacCoin;
import ldts.pacman.sound.SoundPacDies;
import ldts.pacman.sound.SoundStartLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaLoaderTest {
    private Arena arena;
    private ArenaLoader arenaLoader;
    @BeforeEach
    public void setUp() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        this.arenaLoader = new ArenaLoader();
        this.arenaLoader.setLevelNumber(3);

        SoundPacCoin soundPacCoin = Mockito.mock(SoundPacCoin.class);
        SoundPacDies soundPacDies = Mockito.mock(SoundPacDies.class);
        SoundStartLevel soundStartLevel = Mockito.mock(SoundStartLevel.class);

        this.arena = arenaLoader.createArena(soundPacCoin, soundPacDies, soundStartLevel);
    }
    @Test
    public void arenaElements() {
        assertNotNull(arena.getPacman());
        assertEquals(4, arena.getMonsters().size());
        assertEquals(4, arena.getPowerUps().size());
        assertTrue(arena.getCoins().size() > 0);
        assertTrue(arena.getWalls().size() > 0);
    }
}
