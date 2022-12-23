package ldts.pacman.model.game.arena;

import ldts.pacman.model.game.elements.monsters.Monster;
import ldts.pacman.model.game.elements.monsters.MonsterPlayer;

import java.util.List;

public class ArenaLoaderMultiplayer extends ArenaLoader {
    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = createRegularMonsters();
        addMonsterPlayer(monsters);
        return monsters;
    }
    private void addMonsterPlayer(List<Monster> monsters) {
        List<String> lines = getLines();
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                if (lines.get(y).charAt(x) == 'M') {
                    monsters.add(new MonsterPlayer(x, y));
                }
            }
        }
    }
}
