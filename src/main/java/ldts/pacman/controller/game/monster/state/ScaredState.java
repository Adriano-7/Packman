package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.RandomStrategy;

public class ScaredState extends MonsterState {
    @Override
    protected MovementStrategy createStrategy() {
        return new RandomStrategy();
    }
    @Override
    protected char createDrawingChar() {
        return 'c';
    }
}
