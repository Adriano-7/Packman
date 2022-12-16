package ldts.pacman.model.game.arena;
import ldts.pacman.gui.GUI;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.*;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import ldts.pacman.sound.observer.SoundPacCoin;
import ldts.pacman.sound.observer.SoundPacDies;
import ldts.pacman.sound.observer.SoundStartLevel;
import ldts.pacman.sound.subject.SoundSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ldts.pacman.model.game.elements.Monster;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    private Arena arena;
    private SoundSubject soundSubject;
    private SoundPacCoin soundPacCoin;
    private SoundPacDies soundPacDies;
    private SoundStartLevel soundStartLevel;

    @BeforeEach
    public void setUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        soundSubject = Mockito.mock(SoundSubject.class);
        soundPacCoin = Mockito.mock(SoundPacCoin.class);
        soundPacDies = Mockito.mock(SoundPacDies.class);
        soundStartLevel = Mockito.mock(SoundStartLevel.class);
        this.arena = new Arena(10, 20, soundSubject, soundPacCoin, soundPacDies, soundStartLevel);
    }
    @Test
    public void getters() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
    public void isWall() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        arena.setWalls(Arrays.asList(new Wall(10, 30)));
        Position position =new Position(10,30);
        assertEquals(true, arena.isWall(position));
    }

    @Test
    public void isMonster() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Monster monster =new BlueMonster(10,30);
        arena.setMonsters(Arrays.asList(monster));
        Position position=new Position(10,30);
        assertEquals(monster, arena.getCollidingMonster(position));
    }
    @Test
    public void collectCoin() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
    public void collectPowerUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
