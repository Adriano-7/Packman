package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.RandomStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class OrangeMonster extends Monster {
    private final String color = "#db851c";
    public OrangeMonster(int x, int y) {super(x, y);}
    @Override
    public MovementStrategy getMovementStrategy(Arena arena) {return new RandomStrategy(arena);}
    @Override
    public String getColor() {
        return color;
    }
    @Override
    protected Position getAssignedCorner() {
        return new Position(16, 2);
    }
}
