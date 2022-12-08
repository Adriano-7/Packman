package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.movementStrategy.MovementStrategy;
import ldts.pacman.controller.game.movementStrategy.RandomStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class RedMonster extends Monster {
    private final String color = "#d03e19";
    public RedMonster(int x, int y) {super(x, y);}
    @Override
    public MovementStrategy getMovementStrategy(Arena arena) {return new RandomStrategy(arena);}
    @Override
    public String getColor() {
        return color;
    }
    @Override
    protected Position getAssignedCorner() {
        return new Position(16, 17);
    }
    /*

    private Strategy strategy;
    setStrategy(strategy) {
        this.strategy = strategy;
    }
    */
}
