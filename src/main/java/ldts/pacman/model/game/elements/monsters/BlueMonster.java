package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.control.game.MovementStrategy;
import ldts.pacman.control.game.RandomMovement;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class BlueMonster extends Monster {
    private final String color = "#00FFFF";
    public BlueMonster(int x, int y) {super(x, y);}
    @Override
    public MovementStrategy getMovementStrategy(Arena arena) {return new RandomMovement(arena);}
    @Override
    public String getColor() {
        return color;
    }
}
