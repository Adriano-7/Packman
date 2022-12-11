package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;

public class EatenState extends MonsterState {

    @Override
    protected MovementStrategy createStrategy() {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    protected char createDrawingChar() {
        return 0;
    }
}
