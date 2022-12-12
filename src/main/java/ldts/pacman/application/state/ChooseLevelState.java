package ldts.pacman.application.state;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.ChooseLevelController;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.ChooseLevelViewer;
import ldts.pacman.view.menu.OptionsViewer;

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
