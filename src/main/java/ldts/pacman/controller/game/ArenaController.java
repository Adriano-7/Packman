package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.application.state.GameState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.application.state.SaveScoreState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class ArenaController extends GameController {
    private PacmanController pacmanController;
    private MonsterController monsterController;
    public ArenaController(Arena arena) {
        super(arena);
        this.pacmanController = new PacmanController(arena);
        this.monsterController = new MonsterController(arena);
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (options.contains(GUI.OPTION.QUIT) || getModel().getPacman().getHealth() == 0) {
            int score = getModel().getPacman().getScore();
            game.setState(new SaveScoreState(new SaveScore(score)));
        }
        if(getModel().getCoins().isEmpty()) {
            Arena arena = new ArenaLoader(getModel().getLevel()).createArena(getModel().getPacman().getHealth(), getModel().getPacman().getScore());
            game.setState(new GameState(arena));
        }
        else {
            pacmanController.step(game, options, time);
            monsterController.step(game, options, time);
        }
    }
}
