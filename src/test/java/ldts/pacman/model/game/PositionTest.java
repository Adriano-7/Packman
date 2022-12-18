package ldts.pacman.model.game;

import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position position;
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
    public void testEquals() {
        assertFalse(position.equals(null));
        assertFalse(position.equals(new String("ABC")));
        assertTrue(position.equals(position));
        assertTrue(position.equals( new Position(position.getX(), position.getY()) ));
    }
    @Test
    public void plus(){
        Position otherPosition = new Position(10,5);
        assertEquals(new Position(15,4), position.plus(otherPosition));
    }
    @Test public void distance(){
        Position otherPosition=new Position(1,-4);
        double distance=position.distanceTo(otherPosition);
        assertEquals(5,distance);
    }
    @Property
    public void comutativeDistance(@ForAll("generatePosition") Position first, @ForAll("generatePosition") Position second) {
        assertEquals(first.distanceTo(second), second.distanceTo(first));
    }
    @Property
    public void distanceToItself(@ForAll("generatePosition") Position pos){
        assertEquals(0, pos.distanceTo(pos));
    }
    @Property
    public void comutativeSum(@ForAll("generatePosition") Position first, @ForAll("generatePosition") Position second) {
        assertEquals(first.plus(second), second.plus(first));
    }
    @Provide
    Arbitrary<Position> generatePosition() {
        return Combinators.combine(Arbitraries.integers(),Arbitraries.integers()).as(Position::new);
    }
}
