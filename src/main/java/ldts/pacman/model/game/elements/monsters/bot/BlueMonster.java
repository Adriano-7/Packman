package ldts.pacman.model.game.elements.monsters.bot;

import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.model.game.Position;

public class BlueMonster extends MonsterBot {
    public BlueMonster(int x, int y) {
        super(x, y, new Position(2, 2));
    }
    @Override
    public String getBaseColor() {
        return "#46bfee";
    }
}
