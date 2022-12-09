package ldts.pacman.model.game.elements;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;

public abstract class Monster extends MovableElement {
    private Position assignedCorner;
    public Monster(int x, int y){
        super(x,y);
        assignedCorner = getAssignedCorner();
    }
    public abstract MovementStrategy getMovementStrategy(Arena arena);
    public abstract String getColor();
    protected abstract Position getAssignedCorner();
}
