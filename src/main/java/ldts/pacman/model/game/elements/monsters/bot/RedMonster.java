package ldts.pacman.model.game.elements.monsters.bot;

import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.model.game.Position;

public class RedMonster extends MonsterBot {
    public RedMonster(int x, int y) {
        super(x, y, new Position(16, 16));
    }
    @Override
    protected MonsterState createMonsterState() {
        return new ScatterState(getBaseColor());
    }
    @Override
    public String getBaseColor() {
        return "#d03e19";
    }
}
