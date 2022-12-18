package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.monster.state.ChaseState;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.controller.game.movement.strategy.player.MonsterPlayerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class MonsterPlayerTest {
    private MonsterPlayer monsterPlayer;
    @BeforeEach
    public void setUp() {
        monsterPlayer = new MonsterPlayer(5, 5);
    }
    @Test
    public void getBaseColor() {
        assertEquals("#FFFFFF", monsterPlayer.getBaseColor());
    }
    @Test
    public void getState() {
        assertTrue(monsterPlayer.getState() instanceof ChaseState);
    }
    @Test
    public void setState() {
        MonsterState monsterState = Mockito.mock(MonsterState.class);

        monsterPlayer.setState(monsterState);

        Mockito.verify(monsterState, times(1)).setMovementStrategy(Mockito.any(MonsterPlayerStrategy.class));
        assertEquals(monsterState, monsterPlayer.getState());
    }
    @Test
    public void getCornerTarget() {
        assertNull(monsterPlayer.getCornerTarget());
    }
}
