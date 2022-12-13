package ldts.pacman.controller.game.monster.state;

import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals("#46bfee", scaredState.getColor());
    }
    @Test
    public void getDrawingChar() {
        assertEquals('b', scaredState.getDrawingChar());
    }
    @Test
    public void getHit(){
        Arena arena = new Arena(10, 10);

        Pacman pacman = Mockito.mock(Pacman.class);
        arena.setPacman(pacman);

        Monster monster = Mockito.mock(Monster.class);
        arena.setMonsters(Arrays.asList(monster));

        scaredState.getHit(monster, arena);
        Mockito.verify(monster, times(1)).setState(Mockito.any(EatenState.class));
        Mockito.verify(pacman, times(1)).setScore(Mockito.anyInt());
    }
}
