package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.applicationState.MenuState;

import java.io.IOException;

public class SaveScoreController extends Controller<SaveScore> {
    public SaveScoreController(SaveScore model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) throws IOException {
        switch(option) {
            case SELECT:
                new ScoreMenu("/scores.txt")
                        .addScore(getModel().getTimeStamp(), getModel().getScore());
                // fall through
            case QUIT:
                game.setState(new MenuState(new Menu()));
                break;
            default:
                break;
        }
    }
}
