package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

public abstract class Monster extends MovableElement {
    protected MonsterState state;
    protected Monster(int x, int y) {
        super(x, y);
        this.state = createMonsterState();
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
    public abstract String getBaseColor();
}
