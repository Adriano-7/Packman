package ldts.pacman.state;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.ScoreMenuController;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.MenuViewer;
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
        // refused bequest -> doesn't use model (ScoreMenu)
        return new ScoreMenuController(getModel());
    }
}
