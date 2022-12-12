package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.EatenStrategy;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.RandomStrategy;
import ldts.pacman.controller.game.movement.strategy.TargetStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

import static java.lang.Math.pow;

public class EatenState extends MonsterState {
    @Override
    protected MovementStrategy createStrategy() {
        return new EatenStrategy();
    }
    @Override
    public String getColor() {
        // TODO: Color and char
        return "#FFFFFF";
    }

    @Override
    protected boolean enoughTimeElapsed(Monster monster, Arena arena, long time) {
        return time - getLastMovement() > 100;  // 0.1 seconds
    }

    @Override
    public void getHit(Monster monster, Arena arena) {}

    @Override
    protected char createDrawingChar() {
        return 0;
    }
}
