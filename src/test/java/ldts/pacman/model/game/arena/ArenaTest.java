package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.*;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.OrangeMonster;
import ldts.pacman.model.game.elements.monsters.PinkMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import ldts.pacman.sound.observer.SoundPacCoin;
import ldts.pacman.sound.observer.SoundPacDies;
import ldts.pacman.sound.observer.SoundStartLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ldts.pacman.model.game.elements.Monster;
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
    private SoundPacCoin soundPacCoin;
    private SoundPacDies soundPacDies;
    private SoundStartLevel soundStartLevel;

    @BeforeEach
    public void setUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.soundPacCoin = Mockito.mock(SoundPacCoin.class);
        this.soundPacDies = Mockito.mock(SoundPacDies.class);
        this.soundStartLevel = Mockito.mock(SoundStartLevel.class);

        this.arena = new Arena(10, 20, soundPacCoin, soundPacDies, soundStartLevel);
    }
    @Test
    public void testGetWidth() {
        assertEquals(10, arena.getWidth());
    }
    @Test
    public void testGetHeight() {
        assertEquals(20, arena.getHeight());
    }
    @Test void testSetGetPacman(){
        Pacman mockPacman = Mockito.mock(Pacman.class);
        arena.setPacman(mockPacman);
        assertEquals(mockPacman, arena.getPacman());
    }
    @Test
    public void testSetGetCois(){
        List<Coin> mockCoins = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mockCoins.add(Mockito.mock(Coin.class));
        }
        arena.setCoins(mockCoins);
        assertEquals(mockCoins, arena.getCoins());
        assertEquals(10, arena.getCoins().size());
    }
    @Test
    public void testSetGetMonsters(){
        List<Monster> mockMonsters = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mockMonsters.add(Mockito.mock(Monster.class));
        }
        arena.setMonsters(mockMonsters);
        assertEquals(mockMonsters, arena.getMonsters());
        assertEquals(10, arena.getMonsters().size());
    }
    @Test
    public void testSetGetWalls() {
        List<Wall> mockWalls = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mockWalls.add(Mockito.mock(Wall.class));
        }
        arena.setWalls(mockWalls);
        assertEquals(mockWalls, arena.getWalls());
        assertEquals(20, arena.getWalls().size());
    }
    @Test
    public void testSetGetPowerUp(){
        PowerUp mockPowerUp =Mockito.mock(PowerUp.class);
        arena.setPowerUps(Arrays.asList(mockPowerUp));
        assertEquals(Arrays.asList(mockPowerUp),arena.getPowerUps());
    }
    @Test
    public void testIsWall(){
        Wall mockWall1  = Mockito.mock(Wall.class);
        Wall mockWall2  = Mockito.mock(Wall.class);
        Wall mockWall3  = Mockito.mock(Wall.class);
        Mockito.when(mockWall1.getPosition()).thenReturn(new Position(1,7));
        Mockito.when(mockWall2.getPosition()).thenReturn(new Position(1,2));
        Mockito.when(mockWall3.getPosition()).thenReturn(new Position(8,3));

        List<Wall> mockWalls = Arrays.asList(mockWall1, mockWall2, mockWall3);
        arena.setWalls(mockWalls);
        assertTrue(arena.isWall(new Position(1,7)));
        assertTrue(arena.isWall(new Position(1,2)));
        assertTrue(arena.isWall(new Position(8,3)));
        assertFalse(arena.isWall(new Position(1,1)));
        assertFalse(arena.isWall(new Position(1,3)));
    }

    @Test
    public void testGetCollidingMonster() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Monster mockMonster1 = Mockito.mock(RedMonster.class);
        Mockito.when(mockMonster1.getPosition()).thenReturn(new Position(4,6));
        Monster mockMonster2 = Mockito.mock(BlueMonster.class);
        Mockito.when(mockMonster2.getPosition()).thenReturn(new Position(8,2));
        Monster mockMonster3 = Mockito.mock(OrangeMonster.class);
        Mockito.when(mockMonster3.getPosition()).thenReturn(new Position(5,7));
        Monster mockMonster4 = Mockito.mock(PinkMonster.class);
        Mockito.when(mockMonster4.getPosition()).thenReturn(new Position(7,3));


        arena.setMonsters(Arrays.asList(mockMonster1, mockMonster2, mockMonster3, mockMonster4));
        assertEquals(mockMonster1, arena.getCollidingMonster(new Position(4, 6)));
        assertEquals(mockMonster2, arena.getCollidingMonster(new Position(8, 2)));
        assertEquals(mockMonster3, arena.getCollidingMonster(new Position(5, 7)));
        assertEquals(mockMonster4, arena.getCollidingMonster(new Position(7, 3)));
        assertNull(arena.getCollidingMonster(new Position(1, 1)));
    }
    /*
    @Test
    public void testCollidesWithPacman() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Pacman mockPacman = Mockito.mock(Pacman.class);
        Mockito.when(mockPacman.getPosition()).thenReturn(new Position(4,6));
        arena.setPacman(mockPacman);

        Monster mockMonster1 = Mockito.mock(RedMonster.class);
        Mockito.when(mockMonster1.collidesWithPacman(mockPacman)).thenReturn(true);

        Monster mockMonster2 = Mockito.mock(BlueMonster.class);
        Mockito.when(mockMonster2.collidesWithPacman(mockPacman)).thenReturn(false);

        arena.setMonsters(Arrays.asList(mockMonster1, mockMonster2));
        assertTrue(arena.collidesWithPacman(mockMonster1));
        assertFalse(arena.collidesWithPacman(mockMonster2));
    }
*/
    @Test
    public void testResetPositions(){
        Pacman mockPacman = Mockito.mock(Pacman.class);
        Mockito.when(mockPacman.getPosition ()).thenReturn(new Position(4,6));
        arena.setPacman(mockPacman);

        Monster mockMonster1 = Mockito.mock(RedMonster.class);
        Mockito.when(mockMonster1.getPosition()).thenReturn(new Position(4,6));
        Monster mockMonster2 = Mockito.mock(BlueMonster.class);
        Mockito.when(mockMonster2.getPosition()).thenReturn(new Position(8,2));
        Monster mockMonster3 = Mockito.mock(OrangeMonster.class);
        Mockito.when(mockMonster3.getPosition()).thenReturn(new Position(5,7));
        Monster mockMonster4 = Mockito.mock(PinkMonster.class);
        Mockito.when(mockMonster4.getPosition()).thenReturn(new Position(7,3));

        arena.setMonsters(Arrays.asList(mockMonster1, mockMonster2, mockMonster3, mockMonster4));
        arena.resetPositions();
        assertEquals(new Position(4,6), mockPacman.getPosition());
        assertEquals(new Position(4,6), mockMonster1.getPosition());
        assertEquals(new Position(8,2), mockMonster2.getPosition());
        assertEquals(new Position(5,7), mockMonster3.getPosition());
        assertEquals(new Position(7,3), mockMonster4.getPosition());
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
    public void collectPowerUp() {
        Pacman pacman=new Pacman(10,20);
        arena.setPacman(pacman);
        int expectedScore = pacman.getScore() + 1;

        PowerUp powerUp=new PowerUp(10,20);
        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        arena.setPowerUps(powerUps);

        boolean collectedTrue = arena.collectPowerUp();
        assertTrue(collectedTrue);

        assertEquals(expectedScore, arena.getPacman().getScore());
        assertEquals(0, arena.getPowerUps().size());

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
