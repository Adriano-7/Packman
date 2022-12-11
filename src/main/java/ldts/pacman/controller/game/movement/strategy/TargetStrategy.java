package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TargetStrategy extends MovementStrategy {
    @Override
    public boolean move(MovableElement element, Arena arena) {
        Position target = getTarget(element, arena);
        boolean moved = moveToTarget(element, arena, target);
        return moved;
    }
    protected abstract Position getTarget(MovableElement element, Arena arena);
    private boolean moveToTarget(MovableElement element, Arena arena, Position target) {
        List<Position> directions = Arrays.asList(new Position(0, 1), new Position(0, -1),
                new Position(1, 0), new Position(-1, 0));
        List<Position> validDirections = new ArrayList<>();
        Position oppositeDirection = new Position(-element.getDirection().getX(), -element.getDirection().getY());

        for (Position direction : directions) {
            if (!direction.equals(oppositeDirection) && !arena.isWall(element.getPosition().plus(direction))) {
                validDirections.add(direction);
            }
        }

        Position bestDirection = validDirections.get(0);
        double bestDistance = target.distanceTo(element.getPosition().plus(bestDirection));
        for (Position direction : validDirections) {
            double distance = target.distanceTo(element.getPosition().plus(direction));
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
