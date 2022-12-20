package ldts.pacman.model.game.arena;

import ldts.pacman.file.manipulation.ResourceFileReader;
import ldts.pacman.model.game.elements.*;
import ldts.pacman.model.game.elements.monsters.Monster;
import ldts.pacman.model.game.elements.monsters.bot.BlueMonster;
import ldts.pacman.model.game.elements.monsters.bot.OrangeMonster;
import ldts.pacman.model.game.elements.monsters.bot.PinkMonster;
import ldts.pacman.model.game.elements.monsters.bot.RedMonster;
import ldts.pacman.sound.observer.SoundPacCoin;
import ldts.pacman.sound.observer.SoundPacDies;
import ldts.pacman.sound.observer.SoundStartLevel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaLoader {
    private List<String> lines;
    public void setLevelNumber(int levelNumber) throws IOException {
        this.lines = readLines(levelNumber);
    }
    private List<String> readLines(int levelNumber) throws IOException {
        return new ResourceFileReader().readLines("/maps/level" + levelNumber + ".lvl");
    }
    protected List<String> getLines() {
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
    public Arena createArena(SoundPacCoin soundPacCoin, SoundPacDies soundPacDies, SoundStartLevel soundStartLevel) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Arena arena = new Arena(getWidth(), getHeight(), soundPacCoin, soundPacDies, soundStartLevel);

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
    protected List<Monster> createRegularMonsters() {
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
    protected List<Monster> createMonsters() {
        return createRegularMonsters();
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
