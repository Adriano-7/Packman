package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.movement.strategy.player.PacmanStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.application.state.SaveScoreState;
import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

public class ArenaController extends GameController {
    private final List<GameController> controllers;
    public ArenaController(Arena arena) {
        super(arena);
        controllers = new ArrayList<>();
        controllers.add(new PacmanController(arena, new PacmanStrategy()));
        controllers.add(new MonsterController(arena));
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (options.contains(GUI.OPTION.QUIT) || getModel().getPacman().getHealth() == 0) {
            int score = getModel().getPacman().getScore();
            game.setState(new SaveScoreState(new SaveScore(new SoundSelection(), new SoundSubject(), score)));
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