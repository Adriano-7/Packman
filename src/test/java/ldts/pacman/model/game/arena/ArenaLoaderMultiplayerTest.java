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

public class ArenaLoaderMultiplayerTest {
    private Arena arena;
    @BeforeEach
    public void setUp() {
        try {
            ArenaLoader arenaLoader = new ArenaLoaderMultiplayer();
            arenaLoader.setLevelNumber(1);

            SoundPacCoin soundPacCoin = Mockito.mock(SoundPacCoin.class);
            SoundPacDies soundPacDies = Mockito.mock(SoundPacDies.class);
            SoundStartLevel soundStartLevel = Mockito.mock(SoundStartLevel.class);

            this.arena = arenaLoader.createArena(soundPacCoin, soundPacDies, soundStartLevel);
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
