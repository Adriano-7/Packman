package ldts.pacman.model.game.arena;

import ldts.pacman.fileManipulation.ResourceFileReader;
import ldts.pacman.model.game.elements.*;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.OrangeMonster;
import ldts.pacman.model.game.elements.monsters.PinkMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArenaLoader {
    private final List<String> lines;

    public ArenaLoader(int levelNumber) throws IOException {
        lines = new ResourceFileReader().readLines("/maps/level" + levelNumber + ".lvl");
    }
    private int getWidth() {
        int width = 0;
        for (String line: lines) {
            if (line.length() > width) width = line.length();
        }
        return width;
    }
    private int getHeight() {
        return lines.size();
    }
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setCoins(createCoins());
        arena.setPowerUps(createPowerUps());
        return arena;
    }
    private List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++){
            for (int x = 0; x < lines.get(y).length(); x++) {
                if (lines.get(y).charAt(x) == 'o') coins.add(new Coin(x, y));
            }
        }
        return coins;
    }
    private Pacman createPacman() {
        for (int y = 0; y < lines.size(); y++){
            for (int x = 0; x < lines.get(y).length(); x++) {
                if (lines.get(y).charAt(x) == '@') return new Pacman(x, y);
            }
        }
        return null;
    }
    private List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++){
            for (int x = 0; x < lines.get(y).length(); x++) {
                switch (lines.get(y).charAt(x)) {
                    case 'R' -> monsters.add(new RedMonster(x, y));
                    case 'B' -> monsters.add(new BlueMonster(x, y));
                    case 'P' -> monsters.add(new PinkMonster(x, y));
                    case 'O' -> monsters.add(new OrangeMonster(x, y));
                }
            }
        }
        return monsters;
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++){
            for (int x = 0; x < lines.get(y).length(); x++) {
                if (lines.get(y).charAt(x) == '#') walls.add(new Wall(x, y));
            }
        }
        return walls;
    }
    private List<PowerUp> createPowerUps() {
        List<PowerUp> powerUps = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                if (lines.get(y).charAt(x) == 'C') powerUps.add(new PowerUp(x, y));
            }
        }
        return powerUps;
    }
}
