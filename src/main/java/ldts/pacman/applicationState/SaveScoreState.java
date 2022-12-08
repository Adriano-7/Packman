package ldts.pacman.applicationState;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.SaveScoreController;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.SaveScoreViewer;

public class SaveScoreState extends State<SaveScore> {
    public SaveScoreState(SaveScore model) {
        super(model);
    }
    @Override
    protected Viewer<SaveScore> getViewer() {
        return new SaveScoreViewer(getModel());
    }
    @Override
    protected Controller<SaveScore> getController() {
        return new SaveScoreController(getModel());
    }
}
