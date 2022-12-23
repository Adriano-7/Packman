package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.application.state.menu.SaveScoreState;
import ldts.pacman.controller.game.movement.strategy.player.PacmanPlayerStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.menu.options.SaveScore;
import ldts.pacman.sound.SoundSelection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaController extends GameController {
    private final List<GameController> controllers;
    public ArenaController(Arena arena) {
        super(arena);
        controllers = new ArrayList<>();
        controllers.add(new PacmanController(arena, new PacmanPlayerStrategy()));
        controllers.add(new MonsterController(arena));
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (options.contains(GUI.OPTION.QUIT) || getModel().getPacman().getHealth() == 0) {
            int score = getModel().getPacman().getScore();
            game.setState(new SaveScoreState(new SaveScore(new SoundSelection(), score)));
        }
        else if(getModel().getCoins().isEmpty()) {
            getModel().resetLevel();
        }
        else {
            for (GameController controller : controllers) {
                controller.step(game, options, time);
            }
        }
    }
}