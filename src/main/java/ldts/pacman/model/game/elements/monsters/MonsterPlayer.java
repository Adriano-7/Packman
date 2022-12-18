package ldts.pacman.model.game.elements.monsters;

import ldts.pacman.controller.game.monster.state.ChaseState;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.controller.game.movement.strategy.player.MonsterPlayerStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class MonsterPlayer extends Monster {
    public MonsterPlayer(int x, int y) {
        super(x, y, null);  // corner target not used -> should probably create another class MonsterComputer to have this field
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
