package ldts.pacman.control;

import ldts.pacman.control.game.PlayerMovement;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMovementTest {
    PlayerMovement playerMovement;
    Pacman pacman;
    @BeforeEach
    public void setUp() {
        Arena arena = new Arena(10, 10);
        this.pacman = new Pacman(4, -1);
        arena.setPacman(pacman);

        playerMovement = new PlayerMovement(arena);
    }
    @Test
    public void movePacman() {
        Position expected = new Position(5, -1);
        playerMovement.movePlayer(expected);

        assertEquals(expected, pacman.getPosition());
    }
    @Test
    public void movePacmanUp() {
        Position initialPosition = pacman.getPosition();

        Position up = initialPosition.getUp();
        playerMovement.movePlayerUp();

        assertEquals(up, pacman.getPosition());

    }
    @Test
    public void movePacmanDown() {
        Position initialPosition = pacman.getPosition();

        Position down = initialPosition.getDown();
        playerMovement.movePlayerDown();

        assertEquals(down, pacman.getPosition());
    }
    @Test
    public void movePacmanLeft() {
        Position initialPosition = pacman.getPosition();

        Position left = initialPosition.getLeft();
        playerMovement.movePlayerLeft();

        assertEquals(left, pacman.getPosition());
    }
    @Test
    public void movePacmanRight() {
        Position initialPosition = pacman.getPosition();

        Position right = initialPosition.getRight();
        playerMovement.movePlayerRight();

        assertEquals(right, pacman.getPosition());
    }
    @Test
    public void movePacmanInDirection() {
        Position initial = pacman.getPosition();

        playerMovement.setDirection(PlayerMovement.Direction.UP);
        playerMovement.movePlayerInDirection();
        assertEquals(initial.getUp(), pacman.getPosition());

        initial = initial.getUp();

        playerMovement.setDirection(PlayerMovement.Direction.DOWN);
        playerMovement.movePlayerInDirection();
        assertEquals(initial.getDown(), pacman.getPosition());

        initial = initial.getDown();

        playerMovement.setDirection(PlayerMovement.Direction.LEFT);
        playerMovement.movePlayerInDirection();
        assertEquals(initial.getLeft(), pacman.getPosition());

        initial = initial.getLeft();

        playerMovement.setDirection(PlayerMovement.Direction.RIGHT);
        playerMovement.movePlayerInDirection();
        assertEquals(initial.getRight(), pacman.getPosition());

        //initial = initial.getRight();
    }
    @Test
    public void manyMoveInDirection() {
        Position position = pacman.getPosition();

        playerMovement.setDirection(PlayerMovement.Direction.UP);

        playerMovement.movePlayerInDirection();
        playerMovement.movePlayerInDirection();
        playerMovement.movePlayerInDirection();

        assertEquals(position.getUp().getUp().getUp(), pacman.getPosition());
    }
}
