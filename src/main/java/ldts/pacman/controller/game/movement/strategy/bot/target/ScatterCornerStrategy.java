package ldts.pacman.controller.game.movement.strategy.bot.target;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;
import ldts.pacman.model.game.elements.monsters.MonsterBot;

public class ScatterCornerStrategy extends TargetStrategy {
    public ScatterCornerStrategy() {
        super(400);
    }
    @Override
    protected Position getTarget(MovableElement element, Arena arena) {
        MonsterBot monster = (MonsterBot) element;
        return monster.getCornerTarget();
    }
}
