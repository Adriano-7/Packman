package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;
import ldts.pacman.model.game.elements.Pacman;

public class PlayerStrategy extends MovementStrategy {
    public boolean movePlayer(Position position, Arena arena) {
        if (!arena.isWall(position)) {
            arena.getPacman().setPosition(position);
            if (arena.isMonster(position)) {
                Pacman pacman = arena.getPacman();
                pacman.decreaseHealth();
                super.resetPositions(arena);
            }
            // TODO: (for later) if getModel().isPowerUp(Position) -> ...
            return true;
        }
        return false;
    }
    public void changeDirection(GUI.OPTION option, MovableElement element) {
        switch (option) {
            case UP -> element.setDirection(new Position(0, -1));
            case DOWN -> element.setDirection(new Position(0, 1));
            case LEFT -> element.setDirection(new Position(-1, 0));
            case RIGHT -> element.setDirection(new Position(1, 0));
            default -> {}
        }
    }
    @Override
    public boolean move(MovableElement element, Arena arena) {
        if (element.getDirection().equals(new Position(0, 0))) return false;
        Position nextPosition = element.getPosition().plus(element.getDirection());
        return movePlayer(nextPosition, arena);
    }
}
