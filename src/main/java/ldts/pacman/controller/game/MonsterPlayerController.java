package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.movement.strategy.player.MonsterPlayerStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MonsterPlayer;

import java.util.List;

public class MonsterPlayerController extends GameController {
    private long lastMovement;
    private MonsterPlayerStrategy monsterStrategy;
    public MonsterPlayerController(Arena model) {
        super(model);
        monsterStrategy = new MonsterPlayerStrategy();
        lastMovement = 0;
    }
    public MonsterPlayer getMonsterPlayer() {
        return getModel().getMonsterPlayer();
    }

    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) {
        monsterStrategy.changeDirection(options, getMonsterPlayer());
        Arena arena = getModel();
        if (time - lastMovement > 300 && monsterStrategy.move(getMonsterPlayer(), arena)) {
            lastMovement = time;
        }
    }
}
