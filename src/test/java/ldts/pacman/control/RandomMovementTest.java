package ldts.pacman.control;

import ldts.pacman.control.game.RandomMovement;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomMovementTest {
    private RandomMovement randomMovement;
    private Arena arena;
    @BeforeEach
    public void setUp() {
        //Create arena mock using Mockito
        this.arena = Mockito.mock(Arena.class);
        this.randomMovement = new RandomMovement(arena);
    }
    @Test
    public void move4Options() {
        Monster monster = new BlueMonster(5, 5);
        //Mock the isWall method of the arena
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenReturn(false);
        Mockito.when(arena.getPacman()).thenReturn(new Pacman(0, 0));

        randomMovement.move(monster);
        List<Position> possible = Arrays.asList(new Position(6, 5), new Position(4, 5),
                new Position(5, 6), new Position(5, 4));
        assertTrue(possible.contains(monster.getPosition()));
    }

    @Test
    public void moveOneOption() {
        Monster monster = new RedMonster(5, 5);

        List<Wall> walls = Arrays.asList(new Wall(5, 6), new Wall(6, 5), new Wall(4, 5));
        Mockito.when(arena.getWalls()).thenReturn(walls);
        Mockito.when(arena.getPacman()).thenReturn(new Pacman(0, 0));

        //Mock isWall when the position is any of the walls in walls
        Mockito.when(arena.isWall(Mockito.any(Position.class))).thenAnswer(invocation -> {
            Position position = invocation.getArgument(0);
            return walls.stream().anyMatch(wall -> wall.getPosition().equals(position));
        });

        randomMovement.move(monster);
        assertEquals(new Position(5, 4), monster.getPosition());
    }
}
