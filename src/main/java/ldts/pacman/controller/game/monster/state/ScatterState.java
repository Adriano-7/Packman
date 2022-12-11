package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;

public class ScatterState extends MonsterState {
    // needs color in constructor
    private final String color;
    public ScatterState(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
    @Override
    protected MovementStrategy createStrategy() {
        return null;
    }
    @Override
    protected char createDrawingChar() {
        return 0;
    }
}
