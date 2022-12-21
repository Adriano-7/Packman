package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PacmanTest {
    private Pacman pacman;
    private Position initialPosition;
    @BeforeEach
    public void setUp() {
        int x = 5; int y = 3;
        this.initialPosition = new Position(x, y);
        this.pacman = new Pacman(x, y);
    }
    @Test
    public void testSetScore(){
        pacman.setScore(10);
        assertEquals(10,pacman.getScore());
    }
    @Test
    public void testGetPosition() {
        assertEquals(initialPosition, pacman.getPosition());

        Position newPos = new Position(0, -1);
        pacman.setPosition(newPos);
        assertEquals(newPos, pacman.getPosition());
    }
    @Test
    public void testIncreaseScore() {
        int score = pacman.getScore();
        pacman.increaseScore();
        assertEquals(score + 1, pacman.getScore());
    }
    @Test
    public void testDecreaseHealth() {
        int health = pacman.getHealth();
        pacman.decreaseHealth();
        assertEquals(health - 1, pacman.getHealth());
    }
    @Test
    public void collidesWithElement() {
        Element element = Mockito.mock(Element.class);
        Mockito.when(element.getPosition()).thenReturn(new Position(5, 3));

        boolean collided = pacman.collides(element);
        assertTrue(collided);
    }
    @Test
    public void noCollideWithElement() {
        Element element = Mockito.mock(Element.class);
        Mockito.when(element.getPosition()).thenReturn(new Position(0, 0));

        boolean collided = pacman.collides(element);
        assertFalse(collided);
    }
    @Test
    public void initialPosition() {
        pacman.setPosition(new Position(100, -100));

        assertEquals(initialPosition, pacman.getInitialPosition());
    }
}

