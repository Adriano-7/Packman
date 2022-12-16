package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.monster.state.ChaseState;
import ldts.pacman.controller.game.monster.state.ScatterState;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;

public class ChaseStateTest {
    ChaseState chaseState;
    String expectedColor;
    @BeforeEach
    public void setUp() {
        this.expectedColor = "#ABCDEF";
        this.chaseState = new ChaseState(expectedColor);
    }
    @Test
    public void getColor() {
        assertEquals(expectedColor, chaseState.getColor());
    }
    @Test
    public void getHit() {
        Monster monster1 = Mockito.mock(Monster.class);
        Monster monster2 = Mockito.mock(Monster.class);
        Pacman pacman = Mockito.mock(Pacman.class);

        Arena arenaSpy = setUpArena(Arrays.asList(monster1, monster2), pacman);

        chaseState.getHit(null, arenaSpy);

        Mockito.verify(arenaSpy, times(1)).resetPositions();
        Mockito.verify(pacman, times(1)).decreaseHealth();
        verifySetStateOnce(monster1);
        verifySetStateOnce(monster2);

    }
    private void verifySetStateOnce(Monster monster) {
        Mockito.verify(monster, times(1)).setState(Mockito.any(ScatterState.class));
    }
    private Arena setUpArena(List<Monster> monsters, Pacman pacman) {
        Arena arena = null;
        try {
            arena = new Arena(10, 10);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            fail();
        }
        arena.setPacman(pacman);
        arena.setMonsters(monsters);

        return Mockito.spy(arena);
    }
    @Test
    public void getDrawingChar() {
        char[] expected = {'f', 'g', 'h', 'i'};
        char[] actual = chaseState.getDrawingChar();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
