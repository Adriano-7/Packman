package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.movementStrategy.RandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RedMonsterTest {
    private RedMonster redMonster;
    @BeforeEach
    public void setUp() {redMonster = new RedMonster(2, 7);}
    @Test
    public void testRedMonsterMovementStrategy() {
        assertTrue(redMonster.getMovementStrategy(null) instanceof RandomStrategy);
    }
    @Test
    public void testRedMonsterPosition() {
        assertEquals(2, redMonster.getPosition().getX());
        assertEquals(7, redMonster.getPosition().getY());
        assertNotEquals(6, redMonster.getPosition().getX());
        assertNotEquals(6, redMonster.getPosition().getY());
    }
    @Test
    public void testRedMonsterColor(){
        assertEquals("#d03e19", redMonster.getColor());
        assertNotEquals("#000000", redMonster.getColor());
    }
}
