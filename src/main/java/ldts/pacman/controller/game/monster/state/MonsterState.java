package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.monsters.Monster;
import java.util.List;

public abstract class MonsterState {
    private static final long TIME_IN_STATE = 10000; // 10 seconds
    private MovementStrategy movementStrategy;
    private final char[] drawingChar;
    private final long stateStartTime;
    public MonsterState() {
        this.stateStartTime = System.currentTimeMillis();
        movementStrategy = createStrategy();
        drawingChar = createDrawingChar();
    }
    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }
    protected abstract MovementStrategy createStrategy();
    public abstract String getColor();
    public boolean move(Monster monster, Arena arena, List<GUI.OPTION> options, long time) {
        if (!changeState(monster, arena, time)) {
            return movementStrategy.move(monster, arena, options, time);
        }
        return false;
    }
    protected abstract MonsterState getNextState(Monster monster);
    protected boolean changeState(Monster monster, Arena arena, long time) {
        if (time - getStateStartTime() > TIME_IN_STATE) {
            monster.setState(getNextState(monster));
            return true;
        }
        return false;
    }

    public abstract void getHit(Monster monster, Arena arena);
    protected abstract char[] createDrawingChar();
    public char[] getDrawingChar() {
        return drawingChar;
    }
    protected long getStateStartTime() {
        return this.stateStartTime;
    }
}
