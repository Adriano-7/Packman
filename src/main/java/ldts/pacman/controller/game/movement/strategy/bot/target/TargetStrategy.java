package ldts.pacman.controller.game.movement.strategy.bot.target;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.bot.BotStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TargetStrategy extends BotStrategy {
    protected TargetStrategy(long time) {
        super(time);
    }
    @Override
    public boolean move(MovableElement element, Arena arena, List<GUI.OPTION> options, long time) {
        if (enoughTimeElapsed(time)) {
            setLastMovement(time);
            Position target = getTarget(element, arena);
            boolean moved = moveToTarget(element, arena, target);
            return moved;
        }
        return false;
    }
    protected abstract Position getTarget(MovableElement element, Arena arena);
    private boolean moveToTarget(MovableElement element, Arena arena, Position target) {
        List<Position> validDirections = getValidDirections(element, arena);
        Position bestDirection = getBestDirection(element, validDirections, target);

        element.setDirection(bestDirection);
        element.setPosition(element.getPosition().plus(bestDirection));
        return true;
    }
    private Position getBestDirection(MovableElement element, List<Position> validDirections, Position target) {
        Position bestDirection = validDirections.get(0);
        double bestDistance = target.distanceTo(element.getPosition().plus(bestDirection));
        for (Position direction : validDirections) {
            double distance = target.distanceTo(element.getPosition().plus(direction));
            if (distance < bestDistance) {
                bestDirection = direction;
                bestDistance = distance;
            }
        }
        return bestDirection;
    }
}
