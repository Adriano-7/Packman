package ldts.pacman.controller.game;
import ldts.pacman.controller.game.movement.strategy.ScaredStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.Wall;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScaredStrategyTest {
    private ScaredStrategy scaredStrategy;
    private Arena arena;
    @BeforeEach
    public void setUp() {
        //Create arena mock using Mockito
        this.arena = Mockito.mock(Arena.class);
        this.scaredStrategy = new ScaredStrategy();
    }
    @Test
    public void move4Options() {    // TODO: improve test
        Monster monster = new BlueMonster(5, 5);

        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(false);
        Mockito.when(arena.getPacman()).thenReturn(new Pacman(0, 0));

        scaredStrategy.move(monster, arena, null, 1000);
        List<Position> possible = Arrays.asList(new Position(6, 5), new Position(4, 5),
                new Position(5, 6), new Position(5, 4));
        assertTrue(possible.contains(monster.getPosition()));
    }

    @Test
    public void moveOneOption() {    // TODO: improve test
        Monster monster = new RedMonster(5, 5);

        List<Wall> walls = Arrays.asList(new Wall(5, 6), new Wall(6, 5), new Wall(4, 5));
        Mockito.when(arena.getWalls()).thenReturn(walls);
        Mockito.when(arena.getPacman()).thenReturn(new Pacman(0, 0));


        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenAnswer(invocation -> {
            Position position = invocation.getArgument(0);
            return walls.stream().anyMatch(wall -> wall.getPosition().equals(position));
        });

        scaredStrategy.move(monster, arena, null, 1000);
        assertEquals(new Position(5, 4), monster.getPosition());
    }
}
