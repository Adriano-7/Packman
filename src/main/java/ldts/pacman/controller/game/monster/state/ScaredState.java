package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.bot.ScaredStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;

import static java.lang.Math.pow;

public class ScaredState extends MonsterState {
    @Override
    protected MovementStrategy createStrategy() {
        return new ScaredStrategy();
    }
    @Override
    public void getHit(Monster monster, Arena arena) {
        Pacman pacman = arena.getPacman();
        pacman.setScore(pacman.getScore() + 20);
        monster.setState(new EatenState());
    }
    @Override
    public String getColor() {return "#2121ff";}
    @Override
    public MonsterState getNextState(Monster monster) {
        return new ScatterState(monster.getBaseColor());
    }
    @Override
    protected char[] createDrawingChar() {
        return new char[]{'f', 'g', 'h', 'i'};
    }
}
