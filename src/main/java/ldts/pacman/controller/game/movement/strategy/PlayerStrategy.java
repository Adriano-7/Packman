package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;
import ldts.pacman.model.game.elements.Pacman;

import java.util.List;

public class PlayerStrategy extends MovementStrategy {
    public boolean movePlayer(Position position, Arena arena) {
        if (!arena.isWall(position)) {
            arena.getPacman().setPosition(position);
            // TODO: (for later) if getModel().isPowerUp(Position) -> ...
            return true;
        }
        return false;
    }
    public void changeDirection(List<GUI.OPTION> options, MovableElement element) {
        for(GUI.OPTION option: options) {
            switch (option) {
                case UP:
                    element.setDirection(new Position(0, -1));
                    break;
                case DOWN:
                    element.setDirection(new Position(0, 1));
                    break;
                case LEFT:
                    element.setDirection(new Position(-1, 0));
                    break;
                case RIGHT:
                    element.setDirection(new Position(1, 0));
                    break;
            }
        }
    }
    @Override
    public boolean move(MovableElement element, Arena arena) {
        if (element.getDirection().equals(new Position(0, 0))) return false;
        Position nextPosition = element.getPosition().plus(element.getDirection());
        return movePlayer(nextPosition, arena);
    }
}
