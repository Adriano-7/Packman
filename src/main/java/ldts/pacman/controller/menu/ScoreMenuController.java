package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.MainMenuState;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.model.menu.ScoreMenu;


public class ScoreMenuController extends Controller<ScoreMenu> {
    public ScoreMenuController(ScoreMenu model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        if (option == GUI.OPTION.QUIT || option == GUI.OPTION.SELECT) {
            game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
