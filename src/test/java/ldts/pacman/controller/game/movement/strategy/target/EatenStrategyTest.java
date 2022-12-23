package ldts.pacman.controller.game.movement.strategy.target;

import ldts.pacman.controller.game.movement.strategy.bot.target.EatenStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;

public class EatenStrategyTest {
    private EatenStrategy eatenStrategy;
    private Monster monster;
    private Arena arena;
    long timeLimit;

    @BeforeEach
    public void setUp() {
        this.timeLimit = 100;
        this.eatenStrategy = new EatenStrategy();
        this.monster = Mockito.mock(Monster.class);
        this.arena = Mockito.mock(Arena.class);
    }
    @Test
    public void notEnoughTime() {
        for (long timeNotEnough = -100; timeNotEnough <= timeLimit; timeNotEnough++) {
            boolean moved = eatenStrategy.move(null, null, null, timeNotEnough);
            assertFalse(moved);
        }
    }
    @Test
    public void enoughTimeTwice() {
        long enoughTime = timeLimit + 1;

        Position targetPos = new Position(5, 5);
        Position monsterPos = new Position(0, 5);
        Position monsterDir = new Position(0, -1);
        Position expectedDir = new Position(1, 0);
        Position expectedNextPos = new Position(1, 5);

        Pacman pacman = Mockito.mock(Pacman.class);
        Mockito.when(monster.getInitialPosition()).thenReturn(targetPos);
        Mockito.when(arena.getPacman()).thenReturn(pacman);
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(false);

        Mockito.when(monster.getPosition()).thenReturn(monsterPos);
        Mockito.when(monster.getDirection()).thenReturn(monsterDir);

        boolean moved = eatenStrategy.move(monster, arena, null, enoughTime);
        assertTrue(moved);
        Mockito.verify(monster, times(1)).getInitialPosition();
        Mockito.verify(arena, atLeastOnce()).isWall(Mockito.any(Position.class));

        Mockito.verify(monster, times(1)).setDirection(expectedDir);
        Mockito.verify(monster, times(1)).setPosition(expectedNextPos);

        long enoughTimeTwice = enoughTime * 2;
        boolean movedAgain = eatenStrategy.move(monster, arena, null, enoughTimeTwice);
        assertTrue(movedAgain);
    }
}
