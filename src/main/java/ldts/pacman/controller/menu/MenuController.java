package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.state.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu model) {
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

                if (getModel().isSelectedStart()) {
                    game.setState(new GameState(new ArenaLoader(2).createArena()));
                }
                break;
            case QUIT:
                System.exit(0);
                break;
        }
    }
}
