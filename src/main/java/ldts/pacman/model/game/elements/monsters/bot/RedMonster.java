package ldts.pacman.model.game.elements.monsters.bot;

import ldts.pacman.model.game.Position;

public class RedMonster extends MonsterBot {
    public RedMonster(int x, int y) {
        super(x, y, new Position(16, 16));
    }
    @Override
    public String getBaseColor() {
        return "#d03e19";
    }
}
