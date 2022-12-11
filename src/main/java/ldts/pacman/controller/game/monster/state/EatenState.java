package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.RandomStrategy;
import ldts.pacman.controller.game.movement.strategy.TargetStrategy;

public class EatenState extends MonsterState {
    @Override
    protected MovementStrategy createStrategy() {
        // TODO
        // return new TargetStrategy(initialPosition ? of monster);
        return null;
    }
    @Override
    public String getColor() {
        return "#FFFFFF";
    }
    @Override
    protected char createDrawingChar() {
        return 0;
    }
}
