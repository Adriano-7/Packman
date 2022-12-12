package ldts.pacman.controller.game.movement.strategy;


import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.*;

public class ScaredStrategy extends MovementStrategy {
    @Override
    public boolean move(MovableElement element, Arena arena) {
        List<Position> directions = Arrays.asList(new Position(0, 1), new Position(0, -1),
                new Position(1, 0), new Position(-1, 0));

        List<Position> validDirections = new ArrayList<>();
        Position oppositeDirection = new Position(-element.getDirection().getX(), -element.getDirection().getY());

        for (Position direction : directions) {
            if (!direction.equals(oppositeDirection) && !arena.isWall(element.getPosition().plus(direction))) {
                validDirections.add(direction);
            }
        }

        if (validDirections.isEmpty()){
            validDirections.add(oppositeDirection);
        }

        int n = (int) (Math.random() * validDirections.size());
        element.setDirection(validDirections.get(n));
        element.setPosition(element.getPosition().plus(element.getDirection()));
        return true;
    }
}