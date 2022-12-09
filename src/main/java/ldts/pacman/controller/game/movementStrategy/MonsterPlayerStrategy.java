package ldts.pacman.controller.game.movementStrategy;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

public class MonsterPlayerStrategy extends PlayerStrategy {
    public MonsterPlayerStrategy(Arena arena) {
        super(arena);
    }
    @Override
    public void changeDirection(GUI.OPTION option, MovableElement element) {
        switch(option) {
            case W -> element.setDirection(new Position(0, -1));
            case S -> element.setDirection(new Position(0, 1));
            case A -> element.setDirection(new Position(-1, 0));
            case D -> element.setDirection(new Position(1, 0));
            default -> {}
        }
    }
}
