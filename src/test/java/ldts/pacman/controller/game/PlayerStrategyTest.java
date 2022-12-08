package ldts.pacman.controller.game;

import ldts.pacman.controller.game.movementStrategy.PlayerStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.Wall;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerStrategyTest {
    PlayerStrategy playerStrategy;
    Pacman pacman;
    @BeforeEach
    public void setUp() {
        Arena arena = new Arena(10, 10);
        this.pacman = new Pacman(4, -1);
        arena.setPacman(pacman);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(7, 7));
        arena.setWalls(walls);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new RedMonster(9, 5));
        arena.setMonsters(monsters);

        playerStrategy = new PlayerStrategy(arena);
    }
    @Test
    public void movePacman() {
        Position expected = new Position(5, -1);
        playerStrategy.movePlayer(expected);

        assertEquals(expected, pacman.getPosition());
    }
    @Test
    public void movePacmanUp() {
        Position initialPosition = pacman.getPosition();

        Position up = initialPosition.getUp();
        playerStrategy.movePlayerUp();

        assertEquals(up, pacman.getPosition());

    }
    @Test
    public void movePacmanDown() {
        Position initialPosition = pacman.getPosition();

        Position down = initialPosition.getDown();
        playerStrategy.movePlayerDown();

        assertEquals(down, pacman.getPosition());
    }
    @Test
    public void movePacmanLeft() {
        Position initialPosition = pacman.getPosition();

        Position left = initialPosition.getLeft();
        playerStrategy.movePlayerLeft();

        assertEquals(left, pacman.getPosition());
    }
    @Test
    public void movePacmanRight() {
        Position initialPosition = pacman.getPosition();

        Position right = initialPosition.getRight();
        playerStrategy.movePlayerRight();

        assertEquals(right, pacman.getPosition());
    }
    @Test
    public void movePacmanInDirection() {
        Position initial = pacman.getPosition();

        playerStrategy.setDirection(PlayerStrategy.Direction.UP);
        playerStrategy.movePlayerInDirection();
        assertEquals(initial.getUp(), pacman.getPosition());

        initial = initial.getUp();

        playerStrategy.setDirection(PlayerStrategy.Direction.DOWN);
        playerStrategy.movePlayerInDirection();
        assertEquals(initial.getDown(), pacman.getPosition());

        initial = initial.getDown();

        playerStrategy.setDirection(PlayerStrategy.Direction.LEFT);
        playerStrategy.movePlayerInDirection();
        assertEquals(initial.getLeft(), pacman.getPosition());

        initial = initial.getLeft();

        playerStrategy.setDirection(PlayerStrategy.Direction.RIGHT);
        playerStrategy.movePlayerInDirection();
        assertEquals(initial.getRight(), pacman.getPosition());

        //initial = initial.getRight();
    }
    @Test
    public void manyMoveInDirection() {
        Position position = pacman.getPosition();

        playerStrategy.setDirection(PlayerStrategy.Direction.UP);

        playerStrategy.movePlayerInDirection();
        playerStrategy.movePlayerInDirection();
        playerStrategy.movePlayerInDirection();

        assertEquals(position.getUp().getUp().getUp(), pacman.getPosition());
    }
}