package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.monster.state.ScaredState;
import ldts.pacman.controller.game.movement.strategy.player.PacmanStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;

import java.util.List;

public class PacmanController extends GameController {
    private PacmanStrategy pacmanStrategy;
    public PacmanController(Arena model) {
        super(model);
        pacmanStrategy = new PacmanStrategy();
    }
    public Pacman getPacman() {
        return getModel().getPacman();
    }

    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) {
        Arena arena = getModel();
        if (pacmanStrategy.move(getPacman(), arena, options, time)) {
            Position pacmanPos = getPacman().getPosition();
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
