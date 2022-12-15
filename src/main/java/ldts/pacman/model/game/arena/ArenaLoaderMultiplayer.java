package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MonsterPlayer;
import ldts.pacman.model.game.elements.monsters.BlueMonster;
import ldts.pacman.model.game.elements.monsters.OrangeMonster;
import ldts.pacman.model.game.elements.monsters.PinkMonster;
import ldts.pacman.model.game.elements.monsters.RedMonster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaLoaderMultiplayer extends ArenaLoader {
    public ArenaLoaderMultiplayer() {}
    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();
        List<String> lines = getLines();
        for (int y = 0; y < lines.size(); y++){
            for (int x = 0; x < lines.get(y).length(); x++) {
                switch (lines.get(y).charAt(x)) {
                    case 'R' -> monsters.add(new RedMonster(x, y));
                    case 'B' -> monsters.add(new BlueMonster(x, y));
                    case 'P' -> monsters.add(new PinkMonster(x, y));
                    case 'O' -> monsters.add(new OrangeMonster(x, y));
                    case 'M' -> monsters.add(new MonsterPlayer(x, y));
                }
            }
        }
        return monsters;
    }
}
