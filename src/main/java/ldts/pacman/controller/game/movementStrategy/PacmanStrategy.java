package ldts.pacman.controller.game.movementStrategy;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

public class PacmanStrategy extends PlayerStrategy {
    public PacmanStrategy(Arena arena) {
        super(arena);
    }
    @Override
    public void changeDirection(GUI.OPTION option, MovableElement element) {
        switch(option) {
            case UP -> element.setDirection(new Position(0, -1));
            case DOWN -> element.setDirection(new Position(0, 1));
            case LEFT -> element.setDirection(new Position(-1, 0));
            case RIGHT -> element.setDirection(new Position(1, 0));
            default -> {}
        }
    }
}
