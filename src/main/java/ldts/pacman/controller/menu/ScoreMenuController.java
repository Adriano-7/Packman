package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.menu.MainMenuState;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.options.MainMenu;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.sound.observer.SoundSelection;

import java.util.List;


public class ScoreMenuController extends Controller<ScoreMenu> {
    public ScoreMenuController(ScoreMenu model) {
        super(model);
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time){
        for (GUI.OPTION option: options) {
            if (option == GUI.OPTION.QUIT || option == GUI.OPTION.SELECT) {
                game.setState(new MainMenuState(new MainMenu(new SoundSelection())));
            }
        }
    }
}
