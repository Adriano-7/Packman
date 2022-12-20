package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.monsters.Monster;
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
        GUI.OPTION[] options = { GUI.OPTION.DOWN2, GUI.OPTION.UP2, GUI.OPTION.LEFT2, GUI.OPTION.RIGHT2 };
        Position[] correspondingDirections = { new Position(0, 1), new Position(0, -1), new Position(-1, 0), new Position(1, 0) };

        boolean precondition = options.length == correspondingDirections.length;
        assertTrue(precondition);

        int arraySize = options.length;
        for (int i = 0; i < arraySize; i++) {
            monsterPlayerStrategy.changeDirection(List.of(options[i]), monster);
            Mockito.verify(monster, times(1)).setDirection(correspondingDirections[i]);
            Mockito.verifyNoMoreInteractions(monster);
        }
    }
    @Test
    public void moveNoTime() {
        monsterPlayerStrategy = Mockito.spy(monsterPlayerStrategy);
        Mockito.doNothing().when(monsterPlayerStrategy).changeDirection(Mockito.any(), Mockito.any());

        long timeLimit = 250;
        for (long time = -100; time < timeLimit; time += 11) {
            boolean moved = monsterPlayerStrategy.move(monster, null, null, time);
            assertFalse(moved);
        }

        Mockito.verifyNoInteractions(monster);
    }
    private void setUpFieldMocks(Position begin, Position direction) {
        monsterPlayerStrategy = Mockito.spy(monsterPlayerStrategy);
        Mockito.doNothing().when(monsterPlayerStrategy).changeDirection(Mockito.any(), Mockito.any());

        Mockito.when(monster.getDirection()).thenReturn(direction);
        Mockito.when(monster.getPosition()).thenReturn(begin);
    }
    @Test
    public void moveEnoughTime() {
        Position begin = new Position(5, 5);
        Position directionDown = new Position(0, 1);
        setUpFieldMocks(begin, directionDown);

        Position expected = new Position(5, 6);

        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(false);

        boolean moved = monsterPlayerStrategy.move(monster, arena, null, 251);
        assertTrue(moved);

        Mockito.verify(monster, times(1)).setPosition(expected);
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

    @Test
    public void moveEnoughTimeTwice() {
        Position begin = new Position(5, 5);
        Position directionDown = new Position(0, 1);
        setUpFieldMocks(begin, directionDown);

        Position expected = new Position(5, 6);

        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(false);

        boolean movedOnce = monsterPlayerStrategy.move(monster, arena, null, 300);
        boolean movedAgain = monsterPlayerStrategy.move(monster, arena, null, 560);

        assertTrue(movedOnce);
        assertTrue(movedAgain);
        Mockito.verify(monster, times(2)).setPosition(expected);

    }
    @Test
    public void noMoveAllWalls() {
        setUpFieldMocks(new Position(5, 5), new Position(0, 1));
        long enoughTime = 1000;

        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(true);

        boolean moved = monsterPlayerStrategy.move(monster, arena, null, enoughTime);
        assertFalse(moved);

        Mockito.verify(monster, times(0)).setPosition(Mockito.any(Position.class));
    }
}
