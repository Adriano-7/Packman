package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanTest {
    Pacman pacman;
    @BeforeEach
    public void setUp() {
        this.pacman = new Pacman(5, 3);
    }
    @Test
    public void position() {
        assertEquals(new Position(5, 3), pacman.getPosition());

        pacman.setPosition(new Position(0, -1));
        assertEquals(new Position(0, -1), pacman.getPosition());
    }
    @Test
    public void health() {
        int health = pacman.getHealth();

        pacman.decreaseHealth();

        assertEquals(health - 1, pacman.getHealth());
    }
}
