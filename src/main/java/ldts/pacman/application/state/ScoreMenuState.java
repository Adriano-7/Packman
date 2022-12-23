package ldts.pacman.application.state;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.ScoreMenuController;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.ScoreMenuViewer;

public class ScoreMenuState extends State<ScoreMenu> {
    public ScoreMenuState(ScoreMenu model) {
        super(model);
    }
    @Override
    protected Viewer<ScoreMenu> getViewer() {
        return new ScoreMenuViewer(getModel());
    }
    @Override
    protected Controller<ScoreMenu> getController() {
        return new ScoreMenuController(getModel());
    }
}
