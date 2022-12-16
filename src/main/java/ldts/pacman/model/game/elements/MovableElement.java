package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;

public abstract class MovableElement extends Element {
    private final Position initialPosition;
    private Position direction;
    public MovableElement(int x, int y) {
        super(x, y);
        this.initialPosition = new Position(x, y);
        this.direction = new Position(0, 0);
    }
    public Position getInitialPosition() {
        return this.initialPosition;
    }
    public Position getDirection() {
        return this.direction;
    }
    public void setDirection(Position direction) {
        this.direction = direction;
    }
}
