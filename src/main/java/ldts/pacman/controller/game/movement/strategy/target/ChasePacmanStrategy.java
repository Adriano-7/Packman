package ldts.pacman.controller.game.movement.strategy.target;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

public class ChasePacmanStrategy extends TargetStrategy {
    public ChasePacmanStrategy() {
        super(500);
    }

    @Override
    protected Position getTarget(MovableElement element, Arena arena) {
        return arena.getPacman().getPosition();
    }
}
