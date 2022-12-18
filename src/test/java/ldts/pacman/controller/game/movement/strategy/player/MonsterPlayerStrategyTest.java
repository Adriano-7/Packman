package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MonsterPlayer;
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

public class MonsterPlayerStrategyTest {
    private Arena arena;
    private MonsterPlayer monsterPlayer;
    private MonsterPlayerStrategy monsterPlayerStrategy;

    @BeforeEach
    public void setUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.arena = new Arena(10, 10);
        arena.setPacman(new Pacman(4, 1));

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(4, 2));
        arena.setWalls(walls);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new RedMonster(9, 5));

        this.monsterPlayer = new MonsterPlayer(3, 3);
        monsters.add(monsterPlayer);
        this.monsterPlayerStrategy = new MonsterPlayerStrategy();

        arena.setMonsters(monsters);
    }

    @Test
    public void NoOptions() {
        Position expected = new Position(3, 3);
        List<GUI.OPTION> options = new ArrayList<>();

        monsterPlayerStrategy.move(monsterPlayer, arena, options, 251);
        assertTrue(expected.equals(monsterPlayer.getPosition()));
    }

    @Test
    public void notEnoughTimeElapsed() {
        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.RIGHT);
        boolean moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 249);
        assertTrue(!moved);
    }

    @Test
    public void doesNotMoveIntoWall() {
        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.DOWN2);
        boolean moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 251);
        assertTrue(moved);

        options.clear();
        options.add(GUI.OPTION.RIGHT2);
        moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 500);
        assertTrue(!moved);
    }

    @Test
    public void MoveMonsterUp() {
        Position initialPosition = monsterPlayer.getPosition();
        Position expected = initialPosition.plus(new Position(0, -1));

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.UP2);

        boolean moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 300);
        assertTrue(moved);
        assertTrue(expected.equals(monsterPlayer.getPosition()));
    }

    @Test
    public void moveMonsterDown() {
        Position initialPosition = monsterPlayer.getPosition();
        Position expected = initialPosition.plus(new Position(0, 1));

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.DOWN2);

        boolean moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 300);
        assertTrue(moved);
        assertTrue(expected.equals(monsterPlayer.getPosition()));
    }

    @Test
    public void moveMonsterLeft() {
        Position initialPosition = monsterPlayer.getPosition();
        Position expectedPosition = initialPosition.plus(new Position(-1, 0));

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.LEFT2);

        boolean moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 300);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(monsterPlayer.getPosition()));
    }

    @Test
    public void moveMonsterRight() {
        Position initialPosition = monsterPlayer.getPosition();
        Position expectedPosition = initialPosition.plus(new Position(1, 0));

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.RIGHT2);

        boolean moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 300);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(monsterPlayer.getPosition()));
    }


    @Test
    public void continueMovingInSameDirection() {
        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.RIGHT2);
        boolean moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 300);
        assertTrue(moved);
        assertTrue(monsterPlayer.getPosition().equals(new Position(4, 3)));

        options.clear();
        moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 700);
        assertTrue(moved);
        assertTrue(monsterPlayer.getPosition().equals(new Position(5, 3)));

        moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 1000);
        assertTrue(moved);
        assertTrue(monsterPlayer.getPosition().equals(new Position(6, 3)));
    }

    @Test
    public void changeDirections() {
        Position initialPosition = monsterPlayer.getPosition();

        List<GUI.OPTION> options = new ArrayList<>();
        options.add(GUI.OPTION.UP2);

        Position expectedPosition = initialPosition.plus(new Position(0, -1));
        boolean moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 300);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(monsterPlayer.getPosition()));

        options.clear();
        options.add(GUI.OPTION.DOWN2);
        expectedPosition = expectedPosition.plus(new Position(0, 1));
        moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 600);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(monsterPlayer.getPosition()));

        options.clear();
        options.add(GUI.OPTION.LEFT2);
        expectedPosition = expectedPosition.plus(new Position(-1, 0));
        moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 900);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(monsterPlayer.getPosition()));

        options.clear();
        options.add(GUI.OPTION.RIGHT2);
        expectedPosition = expectedPosition.plus(new Position(1, 0));
        moved = monsterPlayerStrategy.move(monsterPlayer, arena, options, 1200);
        assertTrue(moved);
        assertTrue(expectedPosition.equals(monsterPlayer.getPosition()));
    }
}