package ldts.pacman.application.state.menu;

import ldts.pacman.application.state.State;
import ldts.pacman.controller.Controller;
import ldts.pacman.controller.menu.SaveScoreController;
import ldts.pacman.model.menu.options.SaveScore;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.menu.options.OptionsViewer;
import ldts.pacman.view.menu.options.SaveScoreViewer;

public class SaveScoreState extends State<SaveScore> {
    public SaveScoreState(SaveScore model) {
        super(model);
    }
    @Override
    protected Viewer<SaveScore> getViewer() {
        return new SaveScoreViewer(getModel(), new OptionsViewer(getModel()));
    }
    @Override
    protected Controller<SaveScore> getController() {
        return new SaveScoreController(getModel());
    }
}
