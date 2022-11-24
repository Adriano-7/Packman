package ldts.pacman.model.game.elements;

import ldts.pacman.control.game.MovementStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;

public abstract class MovableElement extends Element {
    private final Position initialPosition;
    public MovableElement(int x, int y) {
        super(x, y);
        this.initialPosition = new Position(x, y);
    }
    public Position getInitialPosition() {
        return this.initialPosition;
    }
}
