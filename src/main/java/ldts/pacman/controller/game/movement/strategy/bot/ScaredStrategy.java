package ldts.pacman.controller.game.movement.strategy.bot;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.List;

public class ScaredStrategy extends BotStrategy {
    public ScaredStrategy() {
        super(400);
    }

    private void move(MovableElement element, Arena arena) {
        List<Position> validDirections = getValidDirections(element, arena);

        int n = (int) (Math.random() * validDirections.size());
        Position nextDirection = validDirections.get(n);

        element.setDirection(nextDirection);
        element.setPosition(element.getPosition().plus(nextDirection));
    }
    @Override
    public boolean move(MovableElement element, Arena arena, List<GUI.OPTION> options, long time) {
        if (enoughTimeElapsed(time)) {
            setLastMovement(time);
            move(element, arena);
            return true;
        }
        return false;
    }
}
