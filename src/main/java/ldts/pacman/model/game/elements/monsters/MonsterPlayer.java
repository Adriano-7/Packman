package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.monster.state.ChaseState;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.movement.strategy.player.MonsterPlayerStrategy;

public class MonsterPlayer extends Monster {
    public MonsterPlayer(int x, int y) {
        super(x, y);
    }
    @Override
    protected MonsterState createMonsterState() {
        MonsterState monsterState = new ChaseState(getBaseColor());
        setPlayerStrategy(monsterState);
        return monsterState;
    }
    @Override
    public void setState(MonsterState monsterState) {
        setPlayerStrategy(monsterState);
        this.state = monsterState;
    }
    private void setPlayerStrategy(MonsterState monsterState) {
        monsterState.setMovementStrategy(new MonsterPlayerStrategy());
    }
    @Override
    public String getBaseColor() {
        return "#FFFFFF";
    }
}
