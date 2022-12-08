package ldts.pacman.applicationState;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.MenuController;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.view.Viewer;
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
