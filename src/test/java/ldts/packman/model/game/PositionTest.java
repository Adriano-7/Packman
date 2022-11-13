package ldts.packman.model.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    Position position;
    @BeforeEach
    public void setUp() {
        position = new Position(5, -1);
    }
    @Test
    public void getX() {
        int x = position.getX();
        assertEquals(5, x);
    }
    @Test
    public void getY() {
        int y = position.getY();
        assertEquals(-1, y);
    }
    @Test
    public void getLeft() {
        Position left = position.getLeft();
        assertEquals(4, left.getX());
        assertEquals(-1, left.getY());
    }
    @Test
    public void getRight() {
        Position left = position.getRight();
        assertEquals(6, left.getX());
        assertEquals(-1, left.getY());
    }
    @Test
    public void getUp() {
        Position left = position.getUp();
        assertEquals(5, left.getX());
        assertEquals(-2, left.getY());
    }
    @Test
    public void getDown() {
        Position left = position.getDown();
        assertEquals(5, left.getX());
        assertEquals(0, left.getY());
    }
    @Test
    public void equals() {
        assertFalse(position.equals(null));
        assertFalse(position.equals(new String("ABC")));
        assertTrue(position.equals(position));
        assertTrue(position.equals( new Position(position.getX(), position.getY()) ));
    }
}
