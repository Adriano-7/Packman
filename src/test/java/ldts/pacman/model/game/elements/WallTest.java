package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    private Wall wall;
    @BeforeEach
    public void setUp() {
        wall = new Wall(5, 10);
    }
    @Test
    public void testGetPosition() {
        assertEquals(new Position(5, 10), wall.getPosition());
    }
    @Test
    public void testSetPosition() {
        wall.setPosition(new Position(-5, 2));
        assertEquals(new Position(-5, 2), wall.getPosition());
    }
}
