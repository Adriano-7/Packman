package ldts.pacman.controller.game.movement.strategy.bot;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;
import java.util.*;

public class ScaredStrategy extends BotStrategy {
    public ScaredStrategy() {
        super(400);
    }

    private boolean move(MovableElement element, Arena arena) {
        List<Position> validDirections = getValidDirections(element, arena);

        int n = (int) (Math.random() * validDirections.size());
        Position nextDirection = validDirections.get(n);

        element.setDirection(nextDirection);
        element.setPosition(element.getPosition().plus(nextDirection));
        return true;
    }
    @Override
    public boolean move(MovableElement element, Arena arena, List<GUI.OPTION> options, long time) {
        if (enoughTimeElapsed(time)) {
            setLastMovement(time);
            return move(element, arena);
        }
        return false;
    }
}
