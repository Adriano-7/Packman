package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public abstract class MonsterState {
    private final MovementStrategy movementStrategy;
    private final char drawingChar;
    private long lastMovement;
    private final long stateStartTime;
    public MonsterState() {
        this.lastMovement = 0;
        this.stateStartTime = System.currentTimeMillis();
        movementStrategy = createStrategy();
        drawingChar = createDrawingChar();
    }
    protected abstract MovementStrategy createStrategy();
    public abstract String getColor();
    public boolean move(Monster monster, Arena arena, long time) {
        if (enoughTimeElapsed(monster, arena, time)) {
            movementStrategy.move(monster, arena);
            this.lastMovement = time;
            return true;
        }
        return false;
    }
    protected abstract boolean enoughTimeElapsed(Monster monster, Arena arena, long time);
    public abstract void getHit(Monster monster, Arena arena);
    protected abstract char createDrawingChar();
    public char getDrawingChar() {
        return drawingChar;
    }
    protected long getLastMovement() {
        return this.lastMovement;
    }
    protected long getStateStartTime() {
        return this.stateStartTime;
    }
}
