package ldts.pacman.model.game.elements;

import ldts.pacman.model.game.Position;

public abstract class Element {
    private Position position;
    public Element(int x, int y) {
        this.position = new Position(x, y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public boolean collides(Element other) {
        return this.getPosition().equals(other.getPosition());
    }
}
