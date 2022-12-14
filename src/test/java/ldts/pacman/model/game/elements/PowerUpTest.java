package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerUpTest {
    private PowerUp powerUp;
    @BeforeEach
    public void setUp() {
        powerUp = new PowerUp(2, -1);
    }
    @Test
    public void positionPowerUp(){
        assertEquals(new Position(2,-1),powerUp.getPosition());
    }
    @Test
    public void testSetPosition() {
        powerUp.setPosition(new Position(-5, 2));
        assertEquals(new Position(0, 2), powerUp.getPosition());
    }
}
