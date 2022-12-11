package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.ScatterCornerStrategy;

public class ScatterState extends MonsterState {
    // needs color in constructor
    private final String color;
    public ScatterState(String color) {
        this.color = color;
    }
    @Override
    public String getColor() {
        return this.color;
    }
    @Override
    protected MovementStrategy createStrategy() {
        return new ScatterCornerStrategy();
    }
    @Override
    protected char createDrawingChar() {
        return 0;
    }
}
