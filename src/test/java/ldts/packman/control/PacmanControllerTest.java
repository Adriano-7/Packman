package ldts.packman.control;

import ldts.packman.model.game.Position;
import ldts.packman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanControllerTest {
    PacmanController pacmanControl;
    @BeforeEach
    public void setUp() {
        this.pacmanControl = new PacmanController( new Pacman(-3, 4));
    }
    @Test
    public void movePacman() {
        Position expected = new Position(5, -1);
        pacmanControl.movePacman(expected);

        assertEquals(expected, pacmanControl.getPacman().getPosition());
    }
    @Test
    public void movePacmanUp() {
        Position initialPosition = pacmanControl.getPacman().getPosition();

        Position up = initialPosition.getUp();
        pacmanControl.movePacmanUp();

        assertEquals(up, pacmanControl.getPacman().getPosition());

    }
    @Test
    public void movePacmanDown() {
        Position initialPosition = pacmanControl.getPacman().getPosition();

        Position down = initialPosition.getDown();
        pacmanControl.movePacmanDown();

        assertEquals(down, pacmanControl.getPacman().getPosition());
    }
    @Test
    public void movePacmanLeft() {
        Position initialPosition = pacmanControl.getPacman().getPosition();

        Position left = initialPosition.getLeft();
        pacmanControl.movePacmanLeft();

        assertEquals(left, pacmanControl.getPacman().getPosition());
    }
    @Test
    public void movePacmanRight() {
        Position initialPosition = pacmanControl.getPacman().getPosition();

        Position right = initialPosition.getRight();
        pacmanControl.movePacmanRight();

        assertEquals(right, pacmanControl.getPacman().getPosition());
    }
}
