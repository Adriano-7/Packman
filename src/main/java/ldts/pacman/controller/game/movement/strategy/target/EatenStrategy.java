package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MovableElement;

public class EatenStrategy extends TargetStrategy {
    @Override
    protected Position getTarget(MovableElement element, Arena arena) {
        return element.getInitialPosition();
    }
}
