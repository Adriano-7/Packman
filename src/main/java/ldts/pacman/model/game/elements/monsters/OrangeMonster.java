package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.MovementStrategy;
import ldts.pacman.controller.game.RandomMovement;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class OrangeMonster extends Monster {
    private final String color = "#db851c";
    public OrangeMonster(int x, int y) {super(x, y);}
    @Override
    public MovementStrategy getMovementStrategy(Arena arena) {return new RandomMovement(arena);}
    @Override
    public String getColor() {
        return color;
    }
}