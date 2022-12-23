package ldts.pacman.application.state.menu;

import ldts.pacman.application.state.State;
import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.ChooseLevelController;
import ldts.pacman.model.menu.options.ChooseLevel;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.options.ChooseLevelViewer;
import ldts.pacman.view.menu.options.OptionsViewer;

public class ChooseLevelState extends State<ChooseLevel> {
    public ChooseLevelState(ChooseLevel model) {
        super(model);
    }
    @Override
    protected Viewer<ChooseLevel> getViewer() {
        return new ChooseLevelViewer(getModel(), new OptionsViewer(getModel()));
    }
    @Override
    protected Controller<ChooseLevel> getController() {
        return new ChooseLevelController(getModel());
    }
}
