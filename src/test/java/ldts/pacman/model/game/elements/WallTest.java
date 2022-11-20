package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    Wall wall;
    @BeforeEach
    public void setUp() {
        wall = new Wall(5, 10);
    }
    @Test
    public void getPosition() {
        assertEquals(new Position(5, 10), wall.getPosition());
    }
    @Test
    public void setPosition() {
        wall.setPosition(new Position(-5, 2));
        assertEquals(new Position(-5, 2), wall.getPosition());
    }
}
