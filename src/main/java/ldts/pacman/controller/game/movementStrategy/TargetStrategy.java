package ldts.pacman.controller.game.movementStrategy;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.Arrays;
import java.util.List;

public class TargetStrategy extends MovementStrategy{
    private Position target;

    public TargetStrategy(Arena arena, Position target) {
        super(arena);
        this.target = target;
    }
    private double distanceToTarget(Position p){
        return Math.sqrt((p.getX()-target.getX())^2+(p.getY()-target.getY())^2);
    }

    public boolean move(MovableElement element) {
        // move according to target
        List<Position> directions = Arrays.asList(new Position(0, 1), new Position(0, -1),
                new Position(1, 0), new Position(-1, 0));

        Position sortestPath = directions.get(0);
        for (Position direction: directions) {
            if (direction.equals(element.getDirection()) ||
                    arena.isWall(element.getPosition().add(direction))){
                directions.remove(direction);
            }
            else if (distanceToTarget(direction)<distanceToTarget(sortestPath)){
                sortestPath=direction;
            }
        }
        element.setPosition(sortestPath);
        return true;
    }
}
