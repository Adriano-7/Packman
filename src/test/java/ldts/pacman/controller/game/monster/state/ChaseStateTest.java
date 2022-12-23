package ldts.pacman.controller.game.monster.state;

import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        Arena arenaMock = setUpArena(Arrays.asList(monster1, monster2), pacman);

        chaseState.getHit(null, arenaMock);

        Mockito.verify(arenaMock, times(1)).resetPositions();
        Mockito.verify(pacman, times(1)).decreaseHealth();
        verifySetStateOnce(monster1);
        verifySetStateOnce(monster2);

    }
    private void verifySetStateOnce(Monster monster) {
        Mockito.verify(monster, times(1)).setState(Mockito.any(ScatterState.class));
    }
    private Arena setUpArena(List<Monster> monsters, Pacman pacman) {

        Arena arena = Mockito.mock(Arena.class);

        Mockito.when(arena.getPacman()).thenReturn(pacman);
        Mockito.when(arena.getMonsters()).thenReturn(monsters);

        return arena;
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
