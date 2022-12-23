package ldts.pacman.controller.game.movement.strategy.bot;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BotStrategy extends MovementStrategy {
    protected BotStrategy(long time) {
        super(time);
    }
    protected List<Position> getValidDirections(MovableElement element, Arena arena) {
        List<Position> directions = Arrays.asList(new Position(0, 1), new Position(0, -1),
                new Position(1, 0), new Position(-1, 0));
        List<Position> validDirections = new ArrayList<>();
        Position oppositeDirection = new Position(-element.getDirection().getX(), -element.getDirection().getY());

        for (Position direction : directions) {
            if (!direction.equals(oppositeDirection) && !arena.isWall(element.getPosition().plus(direction))) {
                validDirections.add(direction);
            }
        }
        if (validDirections.isEmpty()) {
            validDirections.add(oppositeDirection);
        }
        return validDirections;
    }
}
