package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import org.junit.jupiter.api.Test;
import ldts.pacman.model.game.elements.Wall;
import ldts.pacman.model.game.elements.Element;
import ldts.pacman.model.game.elements.Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTest {
    @Test
    public void getters() {
        Arena arena = new Arena(10, 20);

        assertEquals(10, arena.getWidth());
        assertEquals(20, arena.getHeight());
    }
    @Test
    public void isWall() {
        Arena arena = new Arena(10,20);
        arena.setWalls(Arrays.asList(new Wall(10, 30)));
        Position position =new Position(10,30);
        assertEquals(true, arena.isWall(position));
    }
    @Test
    public void isMonster(){
        Arena arena = new Arena(10,20);
        Monster monster =new BlueMonster(10,30);
        arena.setMonsters(Arrays.asList(monster));
        Position position=new Position(10,30);
        assertEquals(true,arena.isMonster(position));

    }

}
