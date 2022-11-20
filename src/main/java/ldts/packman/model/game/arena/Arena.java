package ldts.packman.model.game.arena;

import ldts.packman.control.PacmanController;
import ldts.packman.model.game.elements.Coin;
import ldts.packman.model.game.elements.Monster;
import ldts.packman.model.game.elements.Pacman;
import ldts.packman.model.game.elements.Wall;
import ldts.packman.view.PacmanViewer;

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
        coins = new ArrayList<>();
        monsters = new ArrayList<>();
        walls = new ArrayList<>();
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
}
