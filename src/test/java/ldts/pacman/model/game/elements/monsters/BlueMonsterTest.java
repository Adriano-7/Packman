package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.movementStrategy.MovementStrategy;
import ldts.pacman.controller.game.movementStrategy.RandomStrategy;
import ldts.pacman.controller.game.movementStrategy.TargetStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.*;

public class BlueMonsterTest {
    private BlueMonster blueMonster;

    @BeforeEach
    public void setUp() {blueMonster = new BlueMonster(5, 5);}

    @Test
    public void testBlueMonsterMovementStrategy() {
        assertTrue(blueMonster.getMovementStrategy(null) instanceof TargetStrategy);
    }

    @Test
    public void testBlueMonsterPosition() {
        assertEquals(5, blueMonster.getPosition().getX());
        assertEquals(5, blueMonster.getPosition().getY());
        assertNotEquals(6, blueMonster.getPosition().getX());
        assertNotEquals(6, blueMonster.getPosition().getY());
    }

    @Test
    public void testBlueMonsterColor(){
        assertEquals("#46bfee", blueMonster.getColor());
        assertNotEquals("#000000", blueMonster.getColor());
    }
}
