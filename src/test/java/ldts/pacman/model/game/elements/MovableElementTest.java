package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovableElementTest {
    MovableElement movable;
    @BeforeEach
    public void setUp(){
        this.movable=new Pacman(5,10);
    }
    @Test
    public void getInitialPosition(){
        Position position=movable.getInitialPosition();
        assertEquals(position,movable.getPosition());
    }
}
