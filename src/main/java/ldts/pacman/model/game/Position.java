package ldts.pacman.model.game;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;
    public Position(int x, int y){this.x=x; this.y=y;}
    //It's only used in tests, it must be remove

    public int getX(){return this.x;}
    public int getY(){return this.y;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    public Position plus(Position other) {
        return new Position(this.x + other.x, this.y + other.y);
    }
    public double distanceTo(Position other){
        return Math.sqrt(Math.pow(this.x-other.x,2)+Math.pow(this.y-other.y,2));
    }
}
