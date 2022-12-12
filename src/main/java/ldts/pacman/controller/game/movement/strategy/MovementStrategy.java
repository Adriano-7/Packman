package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MovableElement;
import ldts.pacman.model.game.elements.Pacman;

public abstract class MovementStrategy {
    public abstract boolean move(MovableElement element, Arena arena);
}
