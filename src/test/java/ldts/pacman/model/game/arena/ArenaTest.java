package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.*;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ldts.pacman.model.game.elements.Monster;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArenaTest {
    @Test
    public void getters() {
        Arena arena = new Arena(10, 20);
        Pacman pacman = Mockito.mock(Pacman.class);
        arena.setPacman(pacman);
        Coin coin = Mockito.mock(Coin.class);
        arena.setCoins(Arrays.asList(coin));
        Monster monster = Mockito.mock(Monster.class);
        arena.setMonsters(Arrays.asList(monster));
        Wall wall = Mockito.mock(Wall.class);
        arena.setWalls(Arrays.asList(wall));

        assertEquals(10, arena.getWidth());
        assertEquals(20, arena.getHeight());
        assertEquals(pacman,arena.getPacman());
        assertEquals(Arrays.asList(coin),arena.getCoins());
        assertEquals(Arrays.asList(monster),arena.getMonsters());
        assertEquals(Arrays.asList(wall),arena.getWalls());
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
        assertEquals(monster, arena.getCollidingMonster(position));
    }
}
