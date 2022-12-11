package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.TargetStrategy;

public class ChaseState extends MonsterState {
    // needs color in constructor
    private final String color;
    public ChaseState(String color) {
        this.color = color;
    }
    @Override
    protected MovementStrategy createStrategy() {
        // return new TargetStrategy();
        // pacmanPosition as the target
        return null;
    }
    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    protected char createDrawingChar() {
        return 0;
    }
}
