package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.elements.*;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.OrangeMonster;
import ldts.pacman.model.game.elements.monsters.PurpleMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;


public class ArenaLoader {
    private final List<String> lines;

    public ArenaLoader(int levelNumber) throws IOException {
        URL resource = ArenaLoader.class.getResource("/maps/level" + levelNumber + ".lvl");
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        lines = readLines(reader);
    }

    private List<String> readLines(BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null; ) lines.add(line);
        return lines;
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
        // using a switch case for all chars would make code harder to expand
        // using create for each avoids that

        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setCoins(createCoins());
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
                    case 'P' -> monsters.add(new PurpleMonster(x, y));
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
}