package ldts.packman.model.game;

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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
}
