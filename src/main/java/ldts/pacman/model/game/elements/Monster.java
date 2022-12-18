package ldts.pacman.model.game.elements;

import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;

public abstract class Monster extends MovableElement {
    private final Position cornerTarget;
    protected MonsterState state;
    protected Monster(int x, int y, Position cornerTarget) {
        super(x, y);
        this.state = createMonsterState();
        this.cornerTarget = cornerTarget;
    }
    protected abstract MonsterState createMonsterState();
    public void getHit(Arena arena) {
        state.getHit(this, arena);
    }
    public MonsterState getState() {
        return this.state;
    }
    public void setState(MonsterState state) {
        this.state = state;
    }
    public Position getCornerTarget() {
        return this.cornerTarget;
    }
    public abstract String getBaseColor();
}
