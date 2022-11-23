package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.control.game.MovementStrategy;
import ldts.pacman.control.game.RandomMovement;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class OrangeMonster extends Monster {
    private final String color = "#FFB852";
    public OrangeMonster(int x, int y) {super(x, y);}
    @Override
    public MovementStrategy getMovementStrategy(Arena arena) {return new RandomMovement(arena);}
    @Override
    public String getColor() {
        return color;
    }
}