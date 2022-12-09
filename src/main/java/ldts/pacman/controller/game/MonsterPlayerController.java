package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.movementStrategy.MonsterPlayerStrategy;
import ldts.pacman.controller.game.movementStrategy.PacmanStrategy;
import ldts.pacman.controller.game.movementStrategy.PlayerStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MonsterPlayer;
import ldts.pacman.model.game.elements.Pacman;

public class MonsterPlayerController extends GameController {
    private long lastMovement;
    private PlayerStrategy playerStrategy;
    public MonsterPlayerController(Arena model) {
        super(model);
        playerStrategy = new MonsterPlayerStrategy(model);
        lastMovement = 0;
    }
    public MonsterPlayer getMonsterPlayer() {
        return getModel().getMonsterPlayer();
    }

    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        playerStrategy.changeDirection(option, getMonsterPlayer());
        if (time - lastMovement > 300 && playerStrategy.move(getMonsterPlayer())) {
            lastMovement = time;
        }
    }
}
