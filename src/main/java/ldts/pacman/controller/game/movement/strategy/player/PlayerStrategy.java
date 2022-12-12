package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;
import ldts.pacman.model.game.elements.Pacman;

import java.util.List;

public abstract class PlayerStrategy extends MovementStrategy {
    public abstract boolean movePlayer(Position position, Arena arena);

    public abstract void changeDirection(List<GUI.OPTION> options, MovableElement element);
    @Override
    public boolean move(MovableElement element, Arena arena) {
        if (element.getDirection().equals(new Position(0, 0))) return false;
        Position nextPosition = element.getPosition().plus(element.getDirection());
        return movePlayer(nextPosition, arena);
    }
}
