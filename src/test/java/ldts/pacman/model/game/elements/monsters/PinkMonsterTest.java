package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.movementStrategy.RandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PinkMonsterTest {
    private PinkMonster pinkMonster;

    @BeforeEach
    public void setUp() {
        pinkMonster = new PinkMonster(5, 5);}

    @Test
    public void testPinkMonsterMovementStrategy() {
        assertTrue(pinkMonster.getMovementStrategy(null) instanceof RandomStrategy);
    }

    @Test
    public void testPinkMonsterPosition() {
        assertEquals(5, pinkMonster.getPosition().getX());
        assertEquals(5, pinkMonster.getPosition().getY());
        assertNotEquals(6, pinkMonster.getPosition().getX());
        assertNotEquals(6, pinkMonster.getPosition().getY());
    }

    @Test
    public void testPinkMonsterColor(){
        assertEquals("#ea82e5", pinkMonster.getColor());
        assertNotEquals("#000000", pinkMonster.getColor());
    }
}
