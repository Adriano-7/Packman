package ldts.pacman.model.game.elements.monsters.bot;

import ldts.pacman.controller.game.monster.state.ScatterState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RedMonsterTest {
    private RedMonster redMonster;
    @BeforeEach
    public void setUp() {redMonster = new RedMonster(2, 7);}
    @Test
    public void testRedMonsterMovementStrategy() {
        assertTrue(redMonster.getState() instanceof ScatterState);
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
        assertEquals("#d03e19", redMonster.getBaseColor());
        assertNotEquals("#000000", redMonster.getBaseColor());
    }
}
