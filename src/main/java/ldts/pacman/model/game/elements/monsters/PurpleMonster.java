package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.MovementStrategy;
import ldts.pacman.controller.game.RandomMovement;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class PurpleMonster extends Monster {
    private final String color = "#FFB8FF";
    public PurpleMonster(int x, int y) {super(x, y);}
    @Override
    public MovementStrategy getMovementStrategy(Arena arena) {return new RandomMovement(arena);}
    @Override
    public String getColor() {
        return color;
    }
}
