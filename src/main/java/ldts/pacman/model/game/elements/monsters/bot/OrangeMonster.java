package ldts.pacman.model.game.elements.monsters.bot;

import ldts.pacman.model.game.Position;

public class OrangeMonster extends MonsterBot {
    public OrangeMonster(int x, int y) {
        super(x, y, new Position(16, 2));
    }
    @Override
    public String getBaseColor() {
        return "#db851c";
    }
}
