package ldts.pacman.state;

import ldts.pacman.control.Controller;
import ldts.pacman.control.game.GameController;
import ldts.pacman.control.menu.MenuController;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.game.ArenaViewer;
import ldts.pacman.view.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }
    @Override
    protected Viewer<Menu> getViewer() { return new MenuViewer(getModel());}
    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
