package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.target.ScatterCornerStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

import static java.lang.Math.pow;

public class ScatterState extends MonsterState {
    // needs color in constructor
    private final String color;
    public ScatterState(String color) {
        this.color = color;
    }
    @Override
    protected boolean changeState(Monster monster, Arena arena, long time) {
        if (time - getStateStartTime() > pow (10, 4)) { // 10 seconds
            monster.setState(new ChaseState(monster.getBaseColor()));
            return true;
        }
        return false;
    }

    @Override
    public void getHit(Monster monster, Arena arena) {
        arena.resetPositions();
        arena.getPacman().decreaseHealth();
        for (Monster monsterInArena: arena.getMonsters()) {
            monsterInArena.setState(new ScatterState(monsterInArena.getBaseColor()));
        }
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
    protected char[] createDrawingChar() {
        return new char[]{'f', 'g', 'h', 'i'};
    }
}
