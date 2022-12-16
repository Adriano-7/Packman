package ldts.pacman.controller.game.monster.state;

import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;

public class ScaredStateTest {
    private ScaredState scaredState;
    private Monster monster;
    @BeforeEach
    public void setUp(){
        this.scaredState = new ScaredState();
    }
    @Test
    public void getColor(){
        assertEquals("#2121ff", scaredState.getColor());
    }
    @Test
    public void getDrawingChar() {
        char[] expected = {'f', 'g', 'h', 'i'};
        char[] actual = scaredState.getDrawingChar();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
    @Test
    public void getHit(){
        Arena arena = null;
        try {
            arena = new Arena(10, 10);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        Pacman pacman = Mockito.mock(Pacman.class);
        arena.setPacman(pacman);

        Monster monster = Mockito.mock(Monster.class);
        arena.setMonsters(Arrays.asList(monster));

        scaredState.getHit(monster, arena);
        Mockito.verify(monster, times(1)).setState(Mockito.any(EatenState.class));
        Mockito.verify(pacman, times(1)).setScore(Mockito.anyInt());
    }
}
