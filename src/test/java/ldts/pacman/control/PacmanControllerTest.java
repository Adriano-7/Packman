package ldts.pacman.control;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanControllerTest {
    PacmanController pacmanController;
    @BeforeEach
    public void setUp() {
        Arena arena = new Arena(40, 40);

        this.pacmanController = new PacmanController(arena);
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

        pacmanController.changeDirection(GUI.OPTION.UP);
        pacmanController.movePacmanInDirection();
        assertEquals(position.getUp(), pacmanController.getPacman().getPosition());

        position = position.getUp();

        pacmanController.changeDirection(GUI.OPTION.DOWN);
        pacmanController.movePacmanInDirection();
        assertEquals(position.getDown(), pacmanController.getPacman().getPosition());

        position = position.getDown();

        pacmanController.changeDirection(GUI.OPTION.LEFT);
        pacmanController.movePacmanInDirection();
        assertEquals(position.getLeft(), pacmanController.getPacman().getPosition());

        position = position.getLeft();

        pacmanController.changeDirection(GUI.OPTION.RIGHT);
        pacmanController.movePacmanInDirection();
        assertEquals(position.getRight(), pacmanController.getPacman().getPosition());

        position = position.getRight();
    }
    @Test
    public void manyMoveInDirection() {
        Position position = pacmanController.getPacman().getPosition();

        pacmanController.changeDirection(GUI.OPTION.UP);

        pacmanController.movePacmanInDirection();
        pacmanController.movePacmanInDirection();
        pacmanController.movePacmanInDirection();

        assertEquals(position.getUp().getUp().getUp(), pacmanController.getPacman().getPosition());
    }
}
