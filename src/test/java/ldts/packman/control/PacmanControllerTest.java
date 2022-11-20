package ldts.packman.control;

import ldts.packman.model.game.Position;
import ldts.packman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanControllerTest {
    PacmanController pacmanController;
    @BeforeEach
    public void setUp() {
        this.pacmanController = new PacmanController( new Pacman(-3, 4));
    }
    @Test
    public void movePacman() {
        Position expected = new Position(5, -1);
        pacmanController.movePacman(expected);

        assertEquals(expected, pacmanController.getPacman().getPosition());
    }
    @Test
    public void movePacmanUp() {
        Position initialPosition = pacmanController.getPacman().getPosition();

        Position up = initialPosition.getUp();
        pacmanController.movePacmanUp();

        assertEquals(up, pacmanController.getPacman().getPosition());

    }
    @Test
    public void movePacmanDown() {
        Position initialPosition = pacmanController.getPacman().getPosition();

        Position down = initialPosition.getDown();
        pacmanController.movePacmanDown();

        assertEquals(down, pacmanController.getPacman().getPosition());
    }
    @Test
    public void movePacmanLeft() {
        Position initialPosition = pacmanController.getPacman().getPosition();

        Position left = initialPosition.getLeft();
        pacmanController.movePacmanLeft();

        assertEquals(left, pacmanController.getPacman().getPosition());
    }
    @Test
    public void movePacmanRight() {
        Position initialPosition = pacmanController.getPacman().getPosition();

        Position right = initialPosition.getRight();
        pacmanController.movePacmanRight();

        assertEquals(right, pacmanController.getPacman().getPosition());
    }
    @Test
    public void movePacmanInDirection() {
        Position position = pacmanController.getPacman().getPosition();

        pacmanController.setDirection(PacmanController.Direction.UP);
        pacmanController.movePacmanInDirection();
        assertEquals(position.getUp(), pacmanController.getPacman().getPosition());

        position = position.getUp();

        pacmanController.setDirection(PacmanController.Direction.DOWN);
        pacmanController.movePacmanInDirection();
        assertEquals(position.getDown(), pacmanController.getPacman().getPosition());

        position = position.getDown();

        pacmanController.setDirection(PacmanController.Direction.LEFT);
        pacmanController.movePacmanInDirection();
        assertEquals(position.getLeft(), pacmanController.getPacman().getPosition());

        position = position.getLeft();

        pacmanController.setDirection(PacmanController.Direction.RIGHT);
        pacmanController.movePacmanInDirection();
        assertEquals(position.getRight(), pacmanController.getPacman().getPosition());

        position = position.getRight();
    }
    @Test
    public void manyMoveInDirection() {
        Position position = pacmanController.getPacman().getPosition();

        pacmanController.setDirection(PacmanController.Direction.UP);

        pacmanController.movePacmanInDirection();
        pacmanController.movePacmanInDirection();
        pacmanController.movePacmanInDirection();

        assertEquals(position.getUp().getUp().getUp(), pacmanController.getPacman().getPosition());
    }
}
