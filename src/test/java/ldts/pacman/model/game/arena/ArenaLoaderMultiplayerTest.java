package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.elements.MonsterPlayer;
import ldts.pacman.sound.observer.SoundPacCoin;
import ldts.pacman.sound.observer.SoundPacDies;
import ldts.pacman.sound.observer.SoundStartLevel;
import ldts.pacman.sound.subject.SoundSubject;
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
            arenaLoader.setLevelNumber(3);
            SoundSubject soundSubject = Mockito.mock(SoundSubject.class);
            SoundPacCoin soundPacCoin = Mockito.mock(SoundPacCoin.class);
            SoundPacDies soundPacDies = Mockito.mock(SoundPacDies.class);
            SoundStartLevel soundStartLevel = Mockito.mock(SoundStartLevel.class);

            this.arena = arenaLoader.createArena(soundSubject, soundPacCoin, soundPacDies, soundStartLevel);
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
