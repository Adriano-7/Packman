package ldts.pacman.model.game.elements.monsters.bot;

import ldts.pacman.model.game.Position;

public class PinkMonster extends MonsterBot {
    public PinkMonster(int x, int y) {
        super(x, y, new Position(2, 16));
    }
    @Override
    public String getBaseColor() {
        return "#ea82e5";
    }
}
