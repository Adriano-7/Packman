package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.movementStrategy.MovementStrategy;
import ldts.pacman.controller.game.movementStrategy.RandomStrategy;
import ldts.pacman.controller.game.movementStrategy.TargetStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

import java.util.Random;

public class BlueMonster extends Monster {
    private final String color = "#46bfee";
    private MovementStrategy strategy;
    public BlueMonster(int x, int y) {super(x, y);}
    @Override
    public MovementStrategy getMovementStrategy(Arena arena) {
        if (strategy == null) {
            this.strategy = new TargetStrategy(arena, new Position(0, 9));
        }
        return strategy;
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    protected Position getAssignedCorner() {
        return new Position(2, 2);
    }
}
