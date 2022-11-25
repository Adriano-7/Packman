package ldts.pacman.model.game;

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
    public void testGetLeft() {
        Position left = position.getLeft();
        assertEquals(4, left.getX());
        assertEquals(-1, left.getY());
    }
    @Test
    public void testGetRight() {
        Position left = position.getRight();
        assertEquals(6, left.getX());
        assertEquals(-1, left.getY());
    }
    @Test
    public void testGetUp() {
        Position left = position.getUp();
        assertEquals(5, left.getX());
        assertEquals(-2, left.getY());
    }
    @Test
    public void testGetDown() {
        Position left = position.getDown();
        assertEquals(5, left.getX());
        assertEquals(0, left.getY());
    }
    @Test
    public void testGetX() {
        int x = position.getX();
        assertEquals(5, x);
    }
    @Test
    public void testGetY() {
        int y = position.getY();
        assertEquals(-1, y);
    }
    @Test
    public void testGetRandomNeighbour(){
        Position initial_pos= position;
        Position final_pos=position.getRandomNeighbour();
        assertTrue((initial_pos.getDown().equals(final_pos) || initial_pos.getUp().equals(final_pos) || initial_pos.getLeft().equals(final_pos) || initial_pos.getRight().equals(final_pos)));
    }
    @Test
    public void testEquals() {
        assertFalse(position.equals(null));
        assertFalse(position.equals(new String("ABC")));
        assertTrue(position.equals(position));
        assertTrue(position.equals( new Position(position.getX(), position.getY()) ));
    }
}
