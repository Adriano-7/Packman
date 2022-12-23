package ldts.pacman.controller.game.monster.state;

import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

public class ScaredStateTest {
    private ScaredState scaredState;
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
        Monster monster = Mockito.mock(Monster.class);
        Pacman pacman = Mockito.mock(Pacman.class);
        Arena arenaMock = setUpArena(List.of(monster), pacman);

        scaredState.getHit(monster, arenaMock);

        Mockito.verify(monster, times(1)).setState(Mockito.any(EatenState.class));
        Mockito.verify(pacman, times(1)).setScore(Mockito.anyInt());
    }
    private Arena setUpArena(List<Monster> monsters, Pacman pacman) {

        Arena arena = Mockito.mock(Arena.class);

        Mockito.when(arena.getPacman()).thenReturn(pacman);
        Mockito.when(arena.getMonsters()).thenReturn(monsters);

        return arena;
    }
}
