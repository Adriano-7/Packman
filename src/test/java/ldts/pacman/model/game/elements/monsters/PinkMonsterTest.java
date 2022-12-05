package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.RandomMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PinkMonsterTest {
    private PinkMonster pinkMonster;

    @BeforeEach
    public void setUp() {
        pinkMonster = new PinkMonster(5, 5);}

    @Test
    public void testPurpleMonsterMovementStrategy() {
        assertTrue(pinkMonster.getMovementStrategy(null) instanceof RandomMovement);
    }

    @Test
    public void testPurpleMonsterPosition() {
        assertEquals(5, pinkMonster.getPosition().getX());
        assertEquals(5, pinkMonster.getPosition().getY());
        assertNotEquals(6, pinkMonster.getPosition().getX());
        assertNotEquals(6, pinkMonster.getPosition().getY());
    }

    @Test
    public void testPurpleMonsterColor(){
        assertEquals("#FFB8FF", pinkMonster.getColor());
        assertNotEquals("#000000", pinkMonster.getColor());
    }
}
