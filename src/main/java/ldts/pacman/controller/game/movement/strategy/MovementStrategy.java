package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MovableElement;

public abstract class MovementStrategy {
    public abstract boolean move(MovableElement element, Arena arena);
    public void resetPositions(Arena arena) {
        arena.getPacman().setPosition(arena.getPacman().getInitialPosition());
        for (Monster monster: arena.getMonsters()) {
            monster.setPosition(monster.getInitialPosition());
        }
    }
}
