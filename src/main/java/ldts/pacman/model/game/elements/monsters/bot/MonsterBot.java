package ldts.pacman.model.game.elements.monsters.bot;

import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.monsters.Monster;

public abstract class MonsterBot extends Monster {
    private final Position cornerTarget;
    protected MonsterBot(int x, int y, Position cornerTarget) {
        super(x, y);
        this.cornerTarget = cornerTarget;
    }
    @Override
    protected MonsterState createMonsterState() {
        return new ScatterState(getBaseColor());
    }
    public Position getCornerTarget() {
        return this.cornerTarget;
    }
}
