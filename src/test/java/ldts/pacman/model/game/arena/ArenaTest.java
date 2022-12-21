package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.*;
import ldts.pacman.model.game.elements.monsters.bot.BlueMonster;
import ldts.pacman.model.game.elements.monsters.bot.OrangeMonster;
import ldts.pacman.model.game.elements.monsters.bot.PinkMonster;
import ldts.pacman.model.game.elements.monsters.bot.RedMonster;
import ldts.pacman.sound.observer.SoundPacCoin;
import ldts.pacman.sound.observer.SoundPacDies;
import ldts.pacman.sound.observer.SoundStartLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ldts.pacman.model.game.elements.monsters.Monster;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

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
        Mockito.verify(soundStartLevel, times(1)).onSoundEvent();
        Mockito.clearInvocations(soundStartLevel);
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
    public void testSetGetCoins(){
        List<Coin> mockCoins = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            mockCoins.add(Mockito.mock(Coin.class));
        }
        arena.setCoins(mockCoins);
        assertEquals(mockCoins, arena.getCoins());
        assertEquals(size, arena.getCoins().size());
    }
    @Test
    public void testSetGetMonsters(){
        List<Monster> mockMonsters = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            mockMonsters.add(Mockito.mock(Monster.class));
        }
        arena.setMonsters(mockMonsters);
        assertEquals(mockMonsters, arena.getMonsters());
        assertEquals(size, arena.getMonsters().size());
    }
    @Test
    public void testSetGetWalls() {
        List<Wall> mockWalls = new ArrayList<>();
        int size = 20;
        for (int i = 0; i < size; i++) {
            mockWalls.add(Mockito.mock(Wall.class));
        }
        arena.setWalls(mockWalls);
        assertEquals(mockWalls, arena.getWalls());
        assertEquals(size, arena.getWalls().size());
    }
    @Test
    public void testSetGetPowerUp(){
        PowerUp mockPowerUp = Mockito.mock(PowerUp.class);
        arena.setPowerUps(Arrays.asList(mockPowerUp));
        assertEquals(Arrays.asList(mockPowerUp), arena.getPowerUps());
    }
    @Test
    public void testIsWall(){
        Position p1 = new Position(1, 7);
        Position p2 = new Position(1, 2);
        Position p3 = new Position(8, 3);

        Wall mockWall1 = Mockito.mock(Wall.class);
        Wall mockWall2 = Mockito.mock(Wall.class);
        Wall mockWall3 = Mockito.mock(Wall.class);
        Mockito.when(mockWall1.getPosition()).thenReturn(p1);
        Mockito.when(mockWall2.getPosition()).thenReturn(p2);
        Mockito.when(mockWall3.getPosition()).thenReturn(p3);

        List<Wall> mockWalls = Arrays.asList(mockWall1, mockWall2, mockWall3);
        arena.setWalls(mockWalls);
        assertTrue(arena.isWall(p1));
        assertTrue(arena.isWall(p2));
        assertTrue(arena.isWall(p3));

        assertFalse(arena.isWall(new Position(1,1)));
        assertFalse(arena.isWall(new Position(1,3)));
    }

    @Test
    public void testGetCollidingMonster() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Position p1 = new Position(4, 6);
        Position p2 = new Position(8, 2);
        Position p3 = new Position(5, 7);
        Position p4 = new Position(7, 3);

        Monster mockMonster1 = Mockito.mock(RedMonster.class);
        Mockito.when(mockMonster1.getPosition()).thenReturn(p1);

        Monster mockMonster2 = Mockito.mock(BlueMonster.class);
        Mockito.when(mockMonster2.getPosition()).thenReturn(p2);

        Monster mockMonster3 = Mockito.mock(OrangeMonster.class);
        Mockito.when(mockMonster3.getPosition()).thenReturn(p3);

        Monster mockMonster4 = Mockito.mock(PinkMonster.class);
        Mockito.when(mockMonster4.getPosition()).thenReturn(p4);

        arena.setMonsters(Arrays.asList(mockMonster1, mockMonster2, mockMonster3, mockMonster4));

        assertEquals(mockMonster1, arena.getCollidingMonster(p1));
        assertEquals(mockMonster2, arena.getCollidingMonster(p2));
        assertEquals(mockMonster3, arena.getCollidingMonster(p3));
        assertEquals(mockMonster4, arena.getCollidingMonster(p4));
        Mockito.verify(soundPacDies, times(4)).onSoundEvent();

        assertNull(arena.getCollidingMonster(new Position(1, 1)));
    }

    @Test
    public void testCollidesWithPacman() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Pacman mockPacman = Mockito.mock(Pacman.class);
        arena.setPacman(mockPacman);

        Monster mockMonster1 = Mockito.mock(RedMonster.class);
        Mockito.when(mockMonster1.collides(mockPacman)).thenReturn(true);

        Monster mockMonster2 = Mockito.mock(BlueMonster.class);
        Mockito.when(mockMonster2.collides(mockPacman)).thenReturn(false);

        arena.setMonsters(Arrays.asList(mockMonster1, mockMonster2));

        boolean collidedTrue = arena.collidesWithPacman(mockMonster1);
        assertTrue(collidedTrue);
        Mockito.verify(soundPacDies, times(1)).onSoundEvent();

        boolean collidedFalse = arena.collidesWithPacman(mockMonster2);
        assertFalse(collidedFalse);
        Mockito.verifyNoMoreInteractions(soundPacDies);
    }

    @Test
    public void testResetPositions(){
        Position pacmanPos = new Position(4, 6);
        Position posMonster1 = new Position(4, 6);
        Position posMonster2 = new Position(8, 2);
        Position posMonster3 = new Position(5,7);
        Position posMonster4 = new Position(7,3);

        Pacman mockPacman = Mockito.mock(Pacman.class);
        Mockito.when(mockPacman.getInitialPosition()).thenReturn(pacmanPos);
        arena.setPacman(mockPacman);

        Monster mockMonster1 = Mockito.mock(RedMonster.class);
        Mockito.when(mockMonster1.getInitialPosition()).thenReturn(posMonster1);
        Monster mockMonster2 = Mockito.mock(BlueMonster.class);
        Mockito.when(mockMonster2.getInitialPosition()).thenReturn(posMonster2);
        Monster mockMonster3 = Mockito.mock(OrangeMonster.class);
        Mockito.when(mockMonster3.getInitialPosition()).thenReturn(posMonster3);
        Monster mockMonster4 = Mockito.mock(PinkMonster.class);
        Mockito.when(mockMonster4.getInitialPosition()).thenReturn(posMonster4);

        arena.setMonsters(Arrays.asList(mockMonster1, mockMonster2, mockMonster3, mockMonster4));

        arena.resetPositions();

        Mockito.verify(mockPacman).setPosition(pacmanPos);
        Mockito.verify(mockMonster1).setPosition(posMonster1);
        Mockito.verify(mockMonster2).setPosition(posMonster2);
        Mockito.verify(mockMonster3).setPosition(posMonster3);
        Mockito.verify(mockMonster4).setPosition(posMonster4);
    }
    @Test
    public void collectCoin() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Pacman pacman = Mockito.mock(Pacman.class);
        arena.setPacman(pacman);

        Coin coin = Mockito.mock(Coin.class);
        Mockito.when(coin.collides(pacman)).thenReturn(true);
        List<Coin> coins = new ArrayList<>();
        coins.add(coin);
        arena.setCoins(coins);

        arena.collectCoin();

        Mockito.verify(pacman, times(1)).increaseScore();
        Mockito.verify(soundPacCoin, times(1)).onSoundEvent();
        assertEquals(0, arena.getCoins().size());
    }
    @Test
    public void noCollectCoin() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Pacman pacman = Mockito.mock(Pacman.class);
        arena.setPacman(pacman);
        Coin coin = Mockito.mock(Coin.class);
        Mockito.when(coin.collides(pacman)).thenReturn(false);

        List<Coin> coins = new ArrayList<>();
        coins.add(coin);
        arena.setCoins(coins);
        int initialSize = coins.size();

        arena.collectCoin();

        Mockito.verify(pacman, times(0)).increaseScore();
        Mockito.verifyNoMoreInteractions(soundPacCoin);
        assertEquals(initialSize, arena.getCoins().size());

    }
    @Test
    public void collectPowerUpTrue() {
        Pacman pacman = Mockito.mock(Pacman.class);
        arena.setPacman(pacman);

        PowerUp powerUp = Mockito.mock(PowerUp.class);
        Mockito.when(powerUp.collides(pacman)).thenReturn(true);

        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        arena.setPowerUps(powerUps);

        boolean collectedTrue = arena.collectPowerUp();
        assertTrue(collectedTrue);

        Mockito.verify(pacman, times(1)).increaseScore();
        Mockito.verifyNoInteractions(soundPacCoin);
        assertEquals(0, arena.getPowerUps().size());
    }
    @Test
    public void collectPowerUpFalse() {
        Pacman pacman = Mockito.mock(Pacman.class);
        arena.setPacman(pacman);

        PowerUp powerUp = Mockito.mock(PowerUp.class);
        Mockito.when(powerUp.collides(pacman)).thenReturn(false);

        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        arena.setPowerUps(powerUps);

        boolean collectedFalse = arena.collectPowerUp();
        assertFalse(collectedFalse);

        Mockito.verify(pacman, times(0)).increaseScore();
        assertEquals(1, arena.getPowerUps().size());
    }
    @Test
    public void resetLevel() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Pacman pacman = Mockito.mock(Pacman.class);
        arena.setPacman(pacman);

        List<Coin> coins = new ArrayList<>();
        Coin coin = Mockito.mock(Coin.class);
        coins.add(coin);
        arena.setCoins(coins);

        List<PowerUp> powerUps = new ArrayList<>();
        PowerUp powerUp = Mockito.mock(PowerUp.class);
        powerUps.add(powerUp);
        arena.setPowerUps(powerUps);

        Mockito.when(powerUp.collides(pacman)).thenReturn(true);
        Mockito.when(coin.collides(pacman)).thenReturn(true);

        List<Coin> initialCoins = new ArrayList<>(coins);
        List<PowerUp> initialPowerUps = new ArrayList<>(powerUps);

        arena.collectCoin();
        boolean collectedPowerUp = arena.collectPowerUp();
        assertTrue(collectedPowerUp);

        assertEquals(0, arena.getCoins().size());
        assertEquals(0, arena.getPowerUps().size());

        arena.resetLevel();

        assertEquals(initialCoins, arena.getCoins());
        assertEquals(initialPowerUps, arena.getPowerUps());
        Mockito.verify(soundStartLevel, times(1)).onSoundEvent();
    }
}
