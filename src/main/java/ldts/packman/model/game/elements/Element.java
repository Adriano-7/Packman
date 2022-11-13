package ldts.packman.model.game.elements;

import ldts.packman.model.game.Position;

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
}
