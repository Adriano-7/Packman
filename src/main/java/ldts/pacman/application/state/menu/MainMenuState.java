package ldts.pacman.application.state.menu;

import ldts.pacman.application.state.State;
import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.MainMenuController;
import ldts.pacman.model.menu.options.MainMenu;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.options.MainMenuViewer;
import ldts.pacman.view.menu.options.OptionsViewer;

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
