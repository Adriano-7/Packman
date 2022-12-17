package ldts.pacman.model.game.elements;

import ldts.pacman.controller.game.monster.state.ChaseState;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.movement.strategy.player.MonsterPlayerStrategy;

public class MonsterPlayer extends Monster {
    public MonsterPlayer(int x, int y) {
        super(x, y, null);  // corner target not used -> should probably create another class MonsterComputer to have this field
    }
    @Override
    protected MonsterState createMonsterState() {
        MonsterState state = new ChaseState(getBaseColor());
        state.setMovementStrategy(new MonsterPlayerStrategy());
        return state;
    }
    @Override
    public void setState(MonsterState state) {
        state.setMovementStrategy(new MonsterPlayerStrategy());
        this.state = state;
    }
    @Override
    public String getBaseColor() {
        return "#FFFFFF";
    }
}
