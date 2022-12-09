package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MovableElement;

public abstract class MovementStrategy {
    protected Arena arena;
    public MovementStrategy(Arena arena) {
        this.arena = arena;
    }
    public abstract boolean move(MovableElement element);
    public void resetPositions() {
        arena.getPacman().setPosition(arena.getPacman().getInitialPosition());
        for (Monster monster: arena.getMonsters()) {
            monster.setPosition(monster.getInitialPosition());
        }
    }
}
