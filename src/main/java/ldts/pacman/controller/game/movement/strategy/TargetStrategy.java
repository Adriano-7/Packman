package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.ArrayList;
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
    @Override
    public boolean move(MovableElement element) {
        List<Position> directions = Arrays.asList(new Position(0, 1), new Position(0, -1), new Position(1, 0), new Position(-1, 0));
        List<Position> validDirections = new ArrayList<>();
        Position oppositeDirection = new Position(-element.getDirection().getX(), -element.getDirection().getY());

        //remove from directions the opposite direction and every direction that will lead to a wall
        for (Position direction : directions) {
            if (!direction.equals(oppositeDirection) && !arena.isWall(element.getPosition().plus(direction))) {
                validDirections.add(direction);
            }
        }
        //set the direction that will lead to the smallest distance to the target
        Position bestDirection = validDirections.get(0);
        double bestDistance = distanceToTarget(element.getPosition().plus(bestDirection));
        for (Position direction : validDirections) {
            double distance = distanceToTarget(element.getPosition().plus(direction));
            if (distance < bestDistance) {
                bestDirection = direction;
                bestDistance = distance;
            }
        }
        element.setDirection(bestDirection);
        element.setPosition(element.getPosition().plus(bestDirection));
        return true;
    }
}