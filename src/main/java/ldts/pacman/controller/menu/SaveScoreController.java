package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.options.MainMenu;
import ldts.pacman.model.menu.options.SaveScore;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.application.state.menu.MainMenuState;
import ldts.pacman.sound.observer.SoundSelection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class SaveScoreController extends Controller<SaveScore> {
    public SaveScoreController(SaveScore model) {
        super(model);
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        for (GUI.OPTION option: options) {
            switch (option) {
                case UP:
                    getModel().prev_Op();
                    break;
                case DOWN:
                    getModel().next_Op();
                    break;
                case SELECT:
                    if (getModel().isSelectedSave()) {
                        new ScoreMenu("/scores.txt").addScore(getModel().getTimeStamp(), getModel().getScore());
                    }
                    // fall through
                case QUIT:
                    game.setState(new MainMenuState(new MainMenu(new SoundSelection())));
                    break;
                default:
                    break;
            }
        }
    }
}
