package ldts.pacman.model.game.elements;

import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;

public abstract class Monster extends MovableElement {
    private final Position assignedCorner;
    private MonsterState state;
    public Monster(int x, int y){
        super(x,y);
        this.assignedCorner = getAssignedCorner();
        this.state = createMonsterState();
    }
    protected abstract MonsterState createMonsterState();
    public MonsterState getState() {
        return this.state;
    }
    public void setState(MonsterState state) {
        this.state = state;
    }
    protected abstract Position getAssignedCorner();
    public abstract String getBaseColor();
}
