package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.*;
import ldts.pacman.sound.observer.SoundPacCoin;
import ldts.pacman.sound.observer.SoundPacDies;
import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.observer.SoundStartLevel;
import ldts.pacman.sound.subject.SoundSubject;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Pacman pacman;
    private List<Coin> coins;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<PowerUp> powerUps;
    private List<Coin> initialCoins;
    private List<PowerUp> initialPowerUps;
    private int level;
    private SoundPacCoin soundPacCoin;
    private SoundPacDies soundPacDies;
    private SoundStartLevel soundStartLevel;
    protected SoundSubject soundSubject;
    public Arena(int width, int height, SoundSubject soundSubject, SoundPacCoin soundPacCoin, SoundPacDies soundPacDies, SoundStartLevel soundStartLevel) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.width = width;
        this.height = height;
        this.soundSubject = soundSubject;
        this.soundPacCoin = soundPacCoin;
        this.soundPacDies = soundPacDies;
        soundSubject.playSingleSound(soundStartLevel);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Pacman getPacman() {
        return pacman;
    }
    public List<Coin> getCoins() {
        return coins;
    }
    public List<Monster> getMonsters() {
        return monsters;
    }
    public List<Wall> getWalls() {
        return walls;
    }
    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }
    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
    public void setWalls(List<Wall> walls ){
        this.walls=walls;
    }
    public void setCoins(List<Coin> coins) {
        this.coins = coins;
        this.initialCoins = new ArrayList<>(coins);
    }
    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
        this.initialPowerUps = new ArrayList<>(powerUps);
    }
    public boolean isWall(Position position) {
        for (Wall wall: walls) {
            if (wall.getPosition().equals(position)) return true;
        }
        return false;
    }

    public Monster getCollidingMonster(Position position) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for (Monster monster: monsters) {
            if (monster.getPosition().equals(position)) {
                soundSubject.playSingleSound(soundPacDies);
                return monster;
            }
        }
        return null;
    }
    public boolean collidesWithPacman(Monster monster) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (monster.collidesWithPacman(pacman)) {
            soundSubject.playSingleSound(soundPacDies);
            return true;
        }
        return false;
    }
    public void resetPositions() {
        for (Monster monster: monsters) {
            resetPosition(monster);
        }
        resetPosition(pacman);
    }
    private void resetPosition(MovableElement element) {
        element.setPosition(element.getInitialPosition());
    }
    public boolean collectCoin() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Position pacmanPos = pacman.getPosition();
        for (Coin coin: coins) {
            if (coin.getPosition().equals(pacmanPos)) {
                coins.remove(coin);
                pacman.increaseScore();
                soundSubject.playSingleSound(soundPacCoin);
                return true;
            }
        }
        return false;
    }
    public boolean collectPowerUp() {
        Position pacmanPos = pacman.getPosition();
        for (PowerUp powerUp: powerUps) {
            if (powerUp.getPosition().equals(pacmanPos)) {
                powerUps.remove(powerUp);
                pacman.increaseScore();
                return true;
            }
        }
        return false;
    }
    public void resetLevel() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.coins = new ArrayList<>(initialCoins);
        this.powerUps = new ArrayList<>(initialPowerUps);
        soundSubject.playSingleSound(soundStartLevel);
    }
}
