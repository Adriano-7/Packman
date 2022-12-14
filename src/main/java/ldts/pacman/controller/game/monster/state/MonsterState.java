package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

import java.util.List;

public abstract class MonsterState {
    private MovementStrategy movementStrategy;
    private final char drawingChar;
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
    protected abstract boolean changeState(Monster monster, Arena arena, long time);
    public abstract void getHit(Monster monster, Arena arena);
    protected abstract char createDrawingChar();
    public char getDrawingChar() {
        return drawingChar;
    }
    protected long getStateStartTime() {
        return this.stateStartTime;
    }
}
