package ldts.pacman.model.game.elements.monsters;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.monster.state.ScatterState;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.Monster;

public class BlueMonster extends Monster {
    // private final String color = "#46bfee";
    public BlueMonster(int x, int y) {
        super(x, y);
    }
    @Override
    public MonsterState createMonsterState() {
        return new ScatterState(getBaseColor());
    }
    @Override
    protected Position getAssignedCorner() {
        return new Position(2, 2);
    }
    @Override
    public String getBaseColor() {
        return "#46bfee";
    }
}
