package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.monster.state.EatenState;
import ldts.pacman.controller.game.monster.state.ScaredState;
import ldts.pacman.controller.game.movement.strategy.PlayerStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Coin;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.game.elements.PowerUp;

import java.util.List;

public class PacmanController extends GameController {
    private long lastMovement;
    private PlayerStrategy playerStrategy;
    public PacmanController(Arena model) {
        super(model);
        playerStrategy = new PlayerStrategy();
        lastMovement = 0;
    }
    public Pacman getPacman() {
        return getModel().getPacman();
    }

    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) {
        playerStrategy.changeDirection(options, getPacman());
        Arena arena = getModel();
        if (time - lastMovement > 200 && playerStrategy.move(getPacman(), arena)) {
            Position pacmanPos = getPacman().getPosition();
            lastMovement = time;
            Monster monster = arena.getCollidingMonster(pacmanPos);
            if (monster != null) {
                monster.getHit(arena);
            }
            arena.collectCoin();
            if (arena.collectPowerUp()) {
                for (Monster monsterInArena: arena.getMonsters()) monsterInArena.setState(new ScaredState());
            }
        }
    }
}
