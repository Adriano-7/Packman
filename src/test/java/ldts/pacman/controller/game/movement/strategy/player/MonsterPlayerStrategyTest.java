package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MonsterPlayerStrategyTest {
    private MonsterPlayerStrategy monsterPlayerStrategy;
    private Monster monster;
    @BeforeEach
    public void setUp() {
        this.monster = Mockito.mock(Monster.class);
        this.monsterPlayerStrategy = new MonsterPlayerStrategy();
    }
    @Test
    public void changeDirectionNone() {
        List<GUI.OPTION> noneOptions = Arrays.asList(GUI.OPTION.DOWN, GUI.OPTION.UP, GUI.OPTION.LEFT,
                GUI.OPTION.RIGHT, GUI.OPTION.SELECT, GUI.OPTION.QUIT);

        monsterPlayerStrategy.changeDirection(noneOptions, monster);

        Mockito.verifyNoInteractions(monster);
    }
    @Test
    public void changeDirection() {
        monsterPlayerStrategy.changeDirection(List.of(GUI.OPTION.DOWN2), monster);
        Mockito.verify(monster, times(1)).setDirection(new Position(0, 1));

        monsterPlayerStrategy.changeDirection(List.of(GUI.OPTION.UP2), monster);
        Mockito.verify(monster, times(1)).setDirection(new Position(0, -1));

        monsterPlayerStrategy.changeDirection(List.of(GUI.OPTION.LEFT2), monster);
        Mockito.verify(monster, times(1)).setDirection(new Position(-1, 0));

        monsterPlayerStrategy.changeDirection(List.of(GUI.OPTION.RIGHT2), monster);
        Mockito.verify(monster, times(1)).setDirection(new Position(1, 0));
    }
    @Test
    public void moveNoTime() {
        monsterPlayerStrategy = Mockito.spy(monsterPlayerStrategy);
        Mockito.doNothing().when(monsterPlayerStrategy).changeDirection(Mockito.any(), Mockito.any());


        monsterPlayerStrategy.move(monster, null, null, 0);
        monsterPlayerStrategy.move(monster, null, null, 100);
        monsterPlayerStrategy.move(monster, null, null, 250);
        monsterPlayerStrategy.move(monster, null, null, -100);

        Mockito.verifyNoInteractions(monster);
    }
    @Test
    public void moveEnoughTime() {
        monsterPlayerStrategy = Mockito.spy(monsterPlayerStrategy);
        Mockito.doNothing().when(monsterPlayerStrategy).changeDirection(Mockito.any(), Mockito.any());

        Position down = new Position(0, 1);
        Mockito.when(monster.getDirection()).thenReturn(down);
        Mockito.when(monster.getPosition()).thenReturn(new Position(5, 5));

        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(false);

        boolean moved = monsterPlayerStrategy.move(monster, arena, null, 251);
        assertTrue(moved);

        Mockito.verify(monster, times(1)).setPosition(Mockito.any(Position.class));
        Mockito.verify(monster, atLeastOnce()).getDirection();
        Mockito.verify(monster, atLeastOnce()).getPosition();
        Mockito.verifyNoMoreInteractions(monster);


        for (long time = 252; time <= 501; time++) {
            assertFalse(monsterPlayerStrategy.move(monster, arena, null, time));
        }
        Mockito.verify(monster, atLeastOnce()).getDirection();
        Mockito.verify(monster, atLeastOnce()).getPosition();

        Mockito.verifyNoMoreInteractions(monster);
    }
    private void setUpFieldMocks() {
        monsterPlayerStrategy = Mockito.spy(monsterPlayerStrategy);
        Mockito.doNothing().when(monsterPlayerStrategy).changeDirection(Mockito.any(), Mockito.any());

        Position down = new Position(0, 1);
        Mockito.when(monster.getDirection()).thenReturn(down);
        Mockito.when(monster.getPosition()).thenReturn(new Position(5, 5));
    }

    @Test
    public void moveEnoughTimeTwice() {
        setUpFieldMocks();

        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(false);

        boolean movedOnce = monsterPlayerStrategy.move(monster, arena, null, 300);
        boolean movedAgain = monsterPlayerStrategy.move(monster, arena, null, 560);
        assertTrue(movedOnce);
        assertTrue(movedAgain);
        Mockito.verify(monster, times(2)).setPosition(Mockito.any(Position.class));

    }
    @Test
    public void noMoveAllWalls() {
        setUpFieldMocks();

        long timeTest = 1000;
        Mockito.when(monsterPlayerStrategy.enoughTimeElapsed(timeTest)).thenReturn(true);

        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(true);

        boolean moved = monsterPlayerStrategy.move(monster, arena, null, timeTest);
        assertFalse(moved);

        Mockito.verify(monster, times(0)).setPosition(Mockito.any(Position.class));
    }
}
