package ldts.pacman.controller.game.monster.state;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public abstract class MonsterState {
    private final MovementStrategy movementStrategy;
    private String color;
    private final char drawingChar;
    public MonsterState() {
        movementStrategy = createStrategy();
        drawingChar = createDrawingChar();
    }
    protected abstract MovementStrategy createStrategy();
    public abstract String getColor();
    public void move(Monster monster, Arena arena) {
        movementStrategy.move(monster); // TODO (pass arena to parameter instead of constructor)
    }
    protected abstract char createDrawingChar();
    public char getDrawingChar() {
        return drawingChar;
    }
}
