package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.applicationState.ChooseLevelState;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.applicationState.ScoreMenuState;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) throws IOException {
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
                }
                else if (getModel().isSelectedScores()) {
                    game.setState(new ScoreMenuState(new ScoreMenu()));
                }
                break;
            case QUIT:
                System.exit(0);
                break;
        }
    }
}
