package ldts.pacman.controller.game.movement.strategy.bot.target;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

public class EatenStrategy extends TargetStrategy {
    public EatenStrategy() {
        super(100);
    }
    @Override
    protected Position getTarget(MovableElement element, Arena arena) {
        return element.getInitialPosition();
    }
}
