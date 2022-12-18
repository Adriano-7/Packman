package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.Monster;

public class BlueMonster extends MonsterBot {
    public BlueMonster(int x, int y) {
        super(x, y, new Position(2, 2));
    }
    @Override
    public MonsterState createMonsterState() {
        return new ScatterState(getBaseColor());
    }
    @Override
    public String getBaseColor() {
        return "#46bfee";
    }
}
