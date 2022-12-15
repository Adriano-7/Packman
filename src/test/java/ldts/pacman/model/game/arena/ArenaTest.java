package ldts.pacman.model.game.arena;
import ldts.pacman.gui.GUI;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.*;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ldts.pacman.model.game.elements.Monster;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        PowerUp powerUp =Mockito.mock(PowerUp.class);
        arena.setPowerUps(Arrays.asList(powerUp));

        assertEquals(10, arena.getWidth());
        assertEquals(20, arena.getHeight());
        assertEquals(pacman,arena.getPacman());
        assertEquals(Arrays.asList(coin),arena.getCoins());
        assertEquals(Arrays.asList(monster),arena.getMonsters());
        assertEquals(Arrays.asList(wall),arena.getWalls());
        assertEquals(Arrays.asList(powerUp),arena.getPowerUps());
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
    @Test
    public void resetPositions() {
        Arena arena=new Arena(10,20);
        Monster blueMonster=new BlueMonster(10,30);
        Monster redMonster=new RedMonster(20,40);
        Pacman pacman =new Pacman(20,30);
        arena.setMonsters(Arrays.asList(blueMonster,redMonster));
        arena.setPacman(pacman);
        arena.getMonsters().get(0).getState().move(arena.getMonsters().get(0),arena,null,100);
        arena.getMonsters().get(1).getState().move(arena.getMonsters().get(1),arena,null,100);
        pacman.setPosition(new Position(-100, -100));
        arena.resetPositions();
        assertEquals(new Position(10,30),arena.getMonsters().get(0).getPosition());
        assertEquals(new Position(20,40),arena.getMonsters().get(1).getPosition());
        assertEquals(new Position(20,30),arena.getPacman().getPosition());

    }
    @Test
    public void collectCoin() {
        Arena arena = new Arena(10, 20);

        Pacman pacman = new Pacman(10, 20);
        arena.setPacman(pacman);
        int expectedScore = pacman.getScore() + 1;

        Coin coin = new Coin(10, 20);
        List<Coin> coins = new ArrayList<>();
        coins.add(coin);
        arena.setCoins(coins);

        arena.collectCoin();

        assertEquals(expectedScore, arena.getPacman().getScore());
        assertEquals(0, arena.getCoins().size());
    }
    @Test
    public void collectPowerUp(){
        Arena arena=new Arena(10,20);

        Pacman pacman=new Pacman(10,20);
        arena.setPacman(pacman);
        int expectedScore = pacman.getScore() + 1;

        PowerUp powerUp=new PowerUp(10,20);
        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        arena.setPowerUps(powerUps);

        boolean collectedTrue = arena.collectPowerUp();

        assertEquals(expectedScore, arena.getPacman().getScore());
        assertEquals(0, arena.getPowerUps().size());
        assertTrue(collectedTrue);

        PowerUp powerUp1=new PowerUp(10,30);
        List<PowerUp> powerUps1 = new ArrayList<>();
        powerUps1.add(powerUp1);
        arena.setPowerUps(powerUps1);
        boolean collectedFalse=arena.collectPowerUp();
        assertEquals(expectedScore,arena.getPacman().getScore());
        assertEquals(1, arena.getPowerUps().size());
        assertFalse(collectedFalse);
    }
}
