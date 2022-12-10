package ldts.pacman.applicationState;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.MainMenuController;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.MainMenuViewer;
import ldts.pacman.view.menu.OptionsViewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) {
        super(model);
    }
    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel(), new OptionsViewer(getModel()));
    }
    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
