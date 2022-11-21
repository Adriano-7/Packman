package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.elements.Coin;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Pacman pacman;
    private List<Coin> coins;
    private List<Monster> monsters;
    private List<Wall> walls;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        pacman = new Pacman(5, 5);
        coins = createCoins();
        monsters = createMonsters();
        walls = createWalls();
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
    public List<Wall> createWalls() {
        List<Wall> wallList = new ArrayList<>();
        return wallList;
    }
    public List<Coin> createCoins() {
        List<Coin> coinList = new ArrayList<>();
        return coinList;
    }
    public List<Monster> createMonsters() {
        List<Monster> monsterList = new ArrayList<>();
        return monsterList;
    }
}
