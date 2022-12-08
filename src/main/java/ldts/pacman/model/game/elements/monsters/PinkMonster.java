package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.movementStrategy.MovementStrategy;
import ldts.pacman.controller.game.movementStrategy.RandomStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class PinkMonster extends Monster {
    private final String color = "#ea82e5";
    public PinkMonster(int x, int y) {super(x, y);}
    @Override
    public MovementStrategy getMovementStrategy(Arena arena) {return new RandomStrategy(arena);}
    @Override
    public String getColor() {
        return color;
    }
    @Override
    protected Position getAssignedCorner() {
        return new Position(2, 17);
    }
}
