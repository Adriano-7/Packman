package ldts.pacman.applicationState;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.ChooseLevelController;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.ChooseLevelViewer;

public class ChooseLevelState extends State<ChooseLevel> {
    public ChooseLevelState(ChooseLevel model) {
        super(model);
    }
    @Override
    protected Viewer<ChooseLevel> getViewer() {
        return new ChooseLevelViewer(getModel());
    }
    @Override
    protected Controller<ChooseLevel> getController() {
        return new ChooseLevelController(getModel());
    }
}
