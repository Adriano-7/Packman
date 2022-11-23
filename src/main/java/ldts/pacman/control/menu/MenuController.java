package ldts.pacman.control.menu;

import ldts.pacman.Game;
import ldts.pacman.control.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.state.GameState;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        switch (option) {
            case UP:
                getModel().prev_Op();
                break;
            case DOWN:
                getModel().next_Op();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) {game.setState(new GameState(new Arena(10, 10)));}  // TODO: new ArenaLoader
                break;
            case QUIT:
                System.exit(0);
                break;
        }
    }
}
