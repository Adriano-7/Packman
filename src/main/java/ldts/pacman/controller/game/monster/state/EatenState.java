package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.bot.target.EatenStrategy;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.monsters.Monster;

public class EatenState extends MonsterState {
    private final static long TIME_OUT = 6000; // 6 seconds
    @Override
    public MovementStrategy createStrategy() {
        return new EatenStrategy();
    }
    @Override
    public String getColor() {return "#FFFFFF";}

    @Override
    protected MonsterState getNextState(Monster monster) {
        return new ScatterState(monster.getBaseColor());
    }

    @Override
    protected boolean changeState(Monster monster, Arena arena, long time) {
        if (monster.getPosition().equals(monster.getInitialPosition()) || time - getStateStartTime() > TIME_OUT) {
            monster.setState(getNextState(monster));
            monster.setDirection(new Position(0, 0));
            return true;
        }
        return false;
    }
    @Override
    public void getHit(Monster monster, Arena arena) {}

    @Override
    protected char[] createDrawingChar() {
        return new char[]{'m', 'n', 'o', 'p'};
    }
    @Override
    public void setMovementStrategy(MovementStrategy movementStrategy) {}
}
