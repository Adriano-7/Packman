package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.Wall;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class ScaredStrategyTest {
    private ScaredStrategy scaredStrategy;
    private Arena arena;
    private Monster monster;
    @BeforeEach
    public void setUp() {
        this.arena = Mockito.mock(Arena.class);
        this.scaredStrategy = new ScaredStrategy();
        this.monster = Mockito.mock(Monster.class);
    }
    @Test
    public void moveNoTime() {
        long timeLimit = 400;
        for (long time = -100; time <= timeLimit; time += 11) {
            boolean moved = scaredStrategy.move(monster, arena, null, time);
            assertFalse(moved);
        }
        Mockito.verifyNoInteractions(monster);

    }
    @Test
    public void move3OptionsNoWalls() {    // TODO: improve test
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(false);

        Position left = new Position(-1, 0);
        Position right = new Position(1, 0);
        Position up = new Position(0, -1);
        Position down = new Position(0, 1);
        Mockito.when(monster.getDirection()).thenReturn(left);

        Position beginPos = new Position(5, 5);
        Mockito.when(monster.getPosition()).thenReturn(beginPos);

        long timeIncrement = 1000;
        int tries = 100;
        long finalTime = tries * timeIncrement;
        for (long time = 1000; time <= finalTime; time += timeIncrement) {
            scaredStrategy.move(monster, arena, null, time);
        }
        Mockito.verify(monster, times(tries)).setPosition(Mockito.any(Position.class));
        Mockito.verify(monster, times(0)).setDirection(right);

        Mockito.verify(monster, atMost(tries)).setDirection(up);
        Mockito.verify(monster, atMost(tries)).setDirection(down);
        Mockito.verify(monster, atMost(tries)).setDirection(left);
    }

    @Test
    public void moveOneOptionDown() {    // TODO: improve test
        Position beginPos = new Position(5, 5);
        Mockito.when(monster.getPosition()).thenReturn(beginPos);
        Position leftDirection = new Position(-1, 0);
        Mockito.when(monster.getDirection()).thenReturn(leftDirection);

        Position up = new Position(5, 4);
        Position left = new Position(4, 5);
        Position right = new Position(6, 5);
        List<Position> wallPositions = Arrays.asList(up, left, right);

        Position downDirection = new Position(0, 1);
        Position expected = new Position(5, 6);

        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenAnswer(invocation -> {
            Position position = invocation.getArgument(0);
            return wallPositions.contains(position);
        });

        boolean moved = scaredStrategy.move(monster, arena, null, 1000);
        assertTrue(moved);

        verifyMovesOnceInteractions(downDirection, expected);
    }
    @Test
    public void moveOppositeDirection(){
        Position beginPos = new Position(5, 5);
        Mockito.when(monster.getPosition()).thenReturn(beginPos);
        Position downDirection = new Position(0, 1);
        Mockito.when(monster.getDirection()).thenReturn(downDirection);

        Position down = new Position(5, 6);
        Position left = new Position(4, 5);
        Position right = new Position(6, 5);
        List<Position> wallPositions = Arrays.asList(down, left, right);

        Position upDirection = new Position(0, -1);
        Position expected = new Position(5, 4);

        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenAnswer(invocation -> {
            Position position = invocation.getArgument(0);
            return wallPositions.contains(position);
        });

        boolean moved = scaredStrategy.move(monster, arena, null, 1000);
        assertTrue(moved);


        verifyMovesOnceInteractions(upDirection, expected);
    }
    private void verifyMovesOnceInteractions(Position direction, Position expected) {
        Mockito.verify(monster, atLeastOnce()).getPosition();
        Mockito.verify(monster, atLeastOnce()).getDirection();
        Mockito.verify(monster, times(1)).setDirection(direction);
        Mockito.verify(monster, times(1)).setPosition(expected);
    }
}
