package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.MainMenuState;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.sound.SoundObserver;
import ldts.pacman.sound.SoundSelection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;


public class ScoreMenuController extends Controller<ScoreMenu> {
    SoundObserver soundSelection;
    public ScoreMenuController(ScoreMenu model) {
        super(model);
        soundSelection = new SoundSelection();
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for (GUI.OPTION option: options) {
            playSingleSound(soundSelection);
            if (option == GUI.OPTION.QUIT || option == GUI.OPTION.SELECT) {
                game.setState(new MainMenuState(new MainMenu()));
            }
        }
    }
}
