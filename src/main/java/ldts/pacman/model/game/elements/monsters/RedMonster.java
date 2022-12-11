package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.RandomStrategy;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class RedMonster extends Monster {
    // private final String color = "#d03e19";
    public RedMonster(int x, int y) {
        super(x, y);
    }
    @Override
    protected MonsterState createMonsterState() {
        return new ScatterState(getBaseColor());
    }
    @Override
    protected Position getAssignedCorner() {
        return new Position(16, 17);
    }

    @Override
    public String getBaseColor() {
        return "#d03e19";
    }
}
