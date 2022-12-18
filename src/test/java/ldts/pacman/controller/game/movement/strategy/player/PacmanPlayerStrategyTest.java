package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.Wall;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PacmanPlayerStrategyTest {

    private PacmanPlayerStrategy pacmanStrategy;
    private Pacman pacman;
    private Arena arena;

    @BeforeEach
    public void setUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.arena = new Arena(10, 10);
        this.pacman = new Pacman(4, 1);
        arena.setPacman(pacman);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(5, 2));
        arena.setWalls(walls);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new RedMonster(9, 5));
        arena.setMonsters(monsters);

        pacmanStrategy = new PacmanPlayerStrategy();
    }

    @Test
    public void NoOptions() {
        Position expected = new Position(4, 1);
        List<GUI.OPTION> options = new ArrayList<>();

        pacmanStrategy.move(pacman, arena, options, 0);
        assertTrue(expected.equals(pacman.getPosition()));
    }

    @Test
    public void notEnoughTimeElapsed() {
        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.RIGHT);
        boolean moved = pacmanStrategy.move(pacman, arena, options, 100);
        assertTrue(!moved);
    }
    @Test
    public void doesNotMoveIntoWall() {
        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.RIGHT);
        boolean moved = pacmanStrategy.move(pacman, arena, options, 300);
        assertTrue(moved);
        options.clear();

        options.add(GUI.OPTION.DOWN);
        moved = pacmanStrategy.move(pacman, arena, options, 600);
        assertTrue(!moved);
    }

    @Test
    public void MovePacmanUp() {
        Position initialPosition = pacman.getPosition();
        Position expected = initialPosition.plus(new Position(0, -1));

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.UP);

        boolean moved = pacmanStrategy.move(pacman, arena, options, 300);
        assertTrue(moved);
        assertTrue(expected.equals(pacman.getPosition()));
    }

    @Test
    public void movePacmanDown() {
        Position initialPosition = pacman.getPosition();
        Position expected = initialPosition.plus(new Position(0, 1));

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.DOWN);

        boolean moved = pacmanStrategy.move(pacman, arena, options, 300);
        assertTrue(moved);
        assertTrue(expected.equals(pacman.getPosition()));
    }

    @Test
    public void movePacmanLeft() {
        Position initialPosition = pacman.getPosition();
        Position expectedPosition = initialPosition.plus(new Position(-1, 0));

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.LEFT);

        boolean moved = pacmanStrategy.move(pacman, arena, options, 300);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(pacman.getPosition()));
    }

    @Test
    public void movePacmanRight() {
        Position initialPosition = pacman.getPosition();
        Position expectedPosition = initialPosition.plus(new Position(1, 0));

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.RIGHT);

        boolean moved = pacmanStrategy.move(pacman, arena, options, 300);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(pacman.getPosition()));
    }


    @Test
    public void continueMovingInSameDirection() {
        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.RIGHT);
        boolean moved = pacmanStrategy.move(pacman, arena, options, 300);
        assertTrue(moved);
        assertTrue(pacman.getPosition().equals(new Position(5, 1)));

        options.clear();
        moved = pacmanStrategy.move(pacman, arena, options, 600);
        assertTrue(moved);
        assertTrue(pacman.getPosition().equals(new Position(6, 1)));

        moved = pacmanStrategy.move(pacman, arena, options, 900);
        assertTrue(moved);
        assertTrue(pacman.getPosition().equals(new Position(7, 1)));
    }

    @Test
    public void changeDirections() {
        Position initialPosition = pacman.getPosition();

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.UP);

        Position expectedPosition = initialPosition.plus(new Position(0, -1));
        boolean moved = pacmanStrategy.move(pacman, arena, options, 300);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(pacman.getPosition()));

        options.clear();
        options.add(GUI.OPTION.DOWN);
        expectedPosition = expectedPosition.plus(new Position(0, 1));
        moved = pacmanStrategy.move(pacman, arena, options, 600);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(pacman.getPosition()));

        options.clear();
        options.add(GUI.OPTION.LEFT);
        expectedPosition = expectedPosition.plus(new Position(-1, 0));
        moved = pacmanStrategy.move(pacman, arena, options, 900);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(pacman.getPosition()));

        options.clear();
        options.add(GUI.OPTION.RIGHT);
        expectedPosition = expectedPosition.plus(new Position(1, 0));
        moved = pacmanStrategy.move(pacman, arena, options, 1200);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(pacman.getPosition()));
    }
}