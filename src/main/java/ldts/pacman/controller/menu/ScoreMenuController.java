package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.state.MenuState;

import java.io.IOException;

public class ScoreMenuController extends Controller<ScoreMenu> {
    public ScoreMenuController(ScoreMenu model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        if (option == GUI.OPTION.QUIT || option == GUI.OPTION.SELECT) {
            game.setState(new MenuState(new Menu()));
        }
    }
}
