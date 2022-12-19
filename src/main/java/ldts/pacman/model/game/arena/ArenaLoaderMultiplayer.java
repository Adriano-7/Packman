package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.elements.monsters.Monster;
import ldts.pacman.model.game.elements.monsters.MonsterPlayer;
import ldts.pacman.model.game.elements.monsters.bot.BlueMonster;
import ldts.pacman.model.game.elements.monsters.bot.OrangeMonster;
import ldts.pacman.model.game.elements.monsters.bot.PinkMonster;
import ldts.pacman.model.game.elements.monsters.bot.RedMonster;
import java.util.ArrayList;
import java.util.List;

public class ArenaLoaderMultiplayer extends ArenaLoader {
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
