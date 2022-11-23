package ldts.pacman.control;

import ldts.pacman.control.game.PacmanController;
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
        Arena arena = new Arena(10, 10);
        arena.setPacman(new Pacman(4, -1));
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
        Position initial = pacmanController.getPacman().getPosition();

        pacmanController.setDirection(PacmanController.Direction.UP);
        pacmanController.movePacmanInDirection();
        assertEquals(initial.getUp(), pacmanController.getPacman().getPosition());

        initial = initial.getUp();

        pacmanController.setDirection(PacmanController.Direction.DOWN);
        pacmanController.movePacmanInDirection();
        assertEquals(initial.getDown(), pacmanController.getPacman().getPosition());

        initial = initial.getDown();

        pacmanController.setDirection(PacmanController.Direction.LEFT);
        pacmanController.movePacmanInDirection();
        assertEquals(initial.getLeft(), pacmanController.getPacman().getPosition());

        initial = initial.getLeft();

        pacmanController.setDirection(PacmanController.Direction.RIGHT);
        pacmanController.movePacmanInDirection();
        assertEquals(initial.getRight(), pacmanController.getPacman().getPosition());

        //initial = initial.getRight();
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
    @Test
    public void stepNoMovement() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        pacmanController.step(null, GUI.OPTION.NONE, 1000);
        assertEquals(initial, pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.UP, 500);
        assertEquals(initial, pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.LEFT, -1000);
        assertEquals(initial, pacman.getPosition());
    }
    @Test
    public void stepWithMovement() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        pacmanController.step(null, GUI.OPTION.UP, 501);
        assertEquals(initial.getUp(), pacman.getPosition());

        pacmanController.step(null, GUI.OPTION.NONE, 1002);
        assertEquals(initial.getUp().getUp(), pacman.getPosition());

    }
    @Test
    public void stepTimeTesting() {
        Pacman pacman = pacmanController.getModel().getPacman();
        Position initial = pacman.getPosition();

        pacmanController.step(null, GUI.OPTION.NONE, 1000);
        assertEquals(initial, pacman.getPosition());
        // assertEquals(pacman.getLastMovement(), 0);

        pacmanController.step(null, GUI.OPTION.DOWN, 501);
        assertEquals(initial.getDown(), pacman.getPosition());
    }

}
