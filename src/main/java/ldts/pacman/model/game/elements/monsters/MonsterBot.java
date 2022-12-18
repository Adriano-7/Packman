package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.Monster;

public abstract class MonsterBot extends Monster {
    private final Position cornerTarget;
    protected MonsterBot(int x, int y, Position cornerTarget) {
        super(x, y);
        this.cornerTarget = cornerTarget;
    }
    public Position getCornerTarget() {
        return this.cornerTarget;
    }
}
