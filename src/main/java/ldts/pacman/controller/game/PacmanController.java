package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.monster.state.ScaredState;
import ldts.pacman.controller.game.movement.strategy.player.PacmanPlayerStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.monsters.Monster;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class PacmanController extends GameController {
    private final PacmanPlayerStrategy pacmanStrategy;
    public PacmanController(Arena model, PacmanPlayerStrategy pacmanStrategy) {
        super(model);
        this.pacmanStrategy = pacmanStrategy;
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Arena arena = getModel();
        if (pacmanStrategy.move(arena.getPacman(), arena, options, time)) {
            Position pacmanPos = arena.getPacman().getPosition();
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
