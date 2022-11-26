package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.control.game.RandomMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PurpleMonsterTest {
    private PurpleMonster purpleMonster;

    @BeforeEach
    public void setUp() {purpleMonster = new PurpleMonster(5, 5);}

    @Test
    public void testPurpleMonsterMovementStrategy() {
        assertTrue(purpleMonster.getMovementStrategy(null) instanceof RandomMovement);
    }

    @Test
    public void testPurpleMonsterPosition() {
        assertEquals(5, purpleMonster.getPosition().getX());
        assertEquals(5, purpleMonster.getPosition().getY());
        assertNotEquals(6, purpleMonster.getPosition().getX());
        assertNotEquals(6, purpleMonster.getPosition().getY());
    }

    @Test
    public void testPurpleMonsterColor(){
        assertEquals("#FFB8FF", purpleMonster.getColor());
        assertNotEquals("#000000", purpleMonster.getColor());
    }
}
