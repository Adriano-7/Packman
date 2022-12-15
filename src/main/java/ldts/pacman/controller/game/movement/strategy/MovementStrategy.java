package ldts.pacman.controller.game.movement.strategy;

import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MovableElement;
import ldts.pacman.model.game.elements.Pacman;

import java.util.List;

public abstract class MovementStrategy {
    private long lastMovement;
    private final long timeBetweenMoves;

    protected MovementStrategy(long time) {
        this.lastMovement = 0;
        this.timeBetweenMoves = time;
    }
    public abstract boolean move(MovableElement element, Arena arena, List<GUI.OPTION> options, long time);
    public boolean enoughTimeElapsed(long time) {
        return time - lastMovement > timeBetweenMoves;
    }
    public void setLastMovement(long lastMovement) {
        this.lastMovement = lastMovement;
    }
    public long getLastMovement() {
        return lastMovement;
    }
    public long getTimeBetweenMoves() {
        return timeBetweenMoves;
    }
}
