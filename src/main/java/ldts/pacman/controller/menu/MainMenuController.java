package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.ChooseLevelState;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.application.state.ScoreMenuState;
import ldts.pacman.sound.observer.SoundObserver;
import ldts.pacman.sound.observer.SoundSelection;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainMenuController extends Controller<MainMenu> {
    SoundObserver soundSelection;
    public MainMenuController(MainMenu model) {
        super(model);
        soundSelection = new SoundSelection();
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        for (GUI.OPTION option: options) {
            soundSubject.playSingleSound(soundSelection);
            switch (option) {
                case UP:
                    getModel().prev_Op();
                    break;
                case DOWN:
                    getModel().next_Op();
                    break;
                case SELECT:
                    if (getModel().isSelectedExit()) game.setState(null);
                    else if (getModel().isSelectedStart()) {
                        game.setState(new ChooseLevelState(new ChooseLevel()));
                    } else if (getModel().isSelectedScores()) {
                        game.setState(new ScoreMenuState(new ScoreMenu()));
                    }
                    break;
                case QUIT:
                    System.exit(0);
                    break;
            }
        }
    }
}
