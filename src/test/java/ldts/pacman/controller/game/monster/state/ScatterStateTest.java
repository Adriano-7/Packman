package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class ScatterStateTest {
    ScatterState scatterState;
    @BeforeEach
    public void setUp(){
        this.scatterState=new ScatterState("#FFFFFF");
    }

    @Test
    public void getColor(){
        assertEquals("#FFFFFF",scatterState.getColor());
    }
    @Test
    public void getHit(){
        Monster monster1 = Mockito.mock(Monster.class);
        Monster monster2 = Mockito.mock(Monster.class);
        Pacman pacman = Mockito.mock(Pacman.class);

        Arena arenaMock = setUpArena(Arrays.asList(monster1, monster2), pacman);

        scatterState.getHit(null, arenaMock);

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
    public void moveChangesState() {
        MovementStrategy movementStrategy = Mockito.mock(MovementStrategy.class);
        scatterState.setMovementStrategy(movementStrategy);

        Monster monster = Mockito.mock(Monster.class);

        long timeToChangeState = System.currentTimeMillis() + 10001;
        boolean moved = scatterState.move(monster, null, null, timeToChangeState);
        assertFalse(moved);

        Mockito.verify(monster, times(1)).setState(Mockito.any(ChaseState.class));
        Mockito.verifyNoInteractions(movementStrategy);
    }
    @Test
    public void moveNoChangeState() {
        MovementStrategy movementStrategy = Mockito.mock(MovementStrategy.class);
        scatterState.setMovementStrategy(movementStrategy);

        Monster monster = Mockito.mock(Monster.class);

        long timeNoChangeState = 0;
        scatterState.move(monster, null, null, timeNoChangeState);

        Mockito.verify(movementStrategy, times(1)).move(monster, null, null, timeNoChangeState);
        Mockito.verifyNoMoreInteractions(monster);
    }



}
