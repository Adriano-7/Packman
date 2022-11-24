package ldts.pacman.model.game;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;
    public Position(int x, int y){this.x=x; this.y=y;}

    public Position getRight(){return new Position(x+1,y);}
    public Position getLeft(){return new Position(x-1,y);}
    public Position getDown(){return new Position(x,y+1);}
    public Position getUp(){return new Position(x,y-1);}
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public Position getRandomNeighbour(){
        int n=(int) (Math.random()*4);
        return switch (n) {
            case 0 -> getDown();
            case 1 -> getUp();
            case 2 -> getLeft();
            case 3 -> getRight();
            default -> null;
        };
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
