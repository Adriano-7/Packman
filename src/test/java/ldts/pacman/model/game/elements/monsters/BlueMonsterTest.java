package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.model.game.elements.monsters.bot.BlueMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlueMonsterTest {
    private BlueMonster blueMonster;

    @BeforeEach
    public void setUp() {blueMonster = new BlueMonster(5, 5);}

    @Test
    public void testBlueMonsterState() {
        assertTrue(blueMonster.getState() instanceof ScatterState);
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
        assertEquals("#46bfee", blueMonster.getBaseColor());
        assertNotEquals("#000000", blueMonster.getBaseColor());
    }
}
