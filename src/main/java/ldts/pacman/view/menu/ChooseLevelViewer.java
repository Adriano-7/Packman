package ldts.pacman.view.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.view.Viewer;

import java.io.IOException;

public class ChooseLevelViewer extends Viewer<ChooseLevel> {
    private final OptionsViewer optionsViewer;
    public ChooseLevelViewer(ChooseLevel model, OptionsViewer optionsViewer) {
        super(model);
        // assert (optionsViewer.getModel() == model);
        this.optionsViewer = optionsViewer;
    }
    @Override
    protected void drawElements(GUI gui) {
        /*
        // TODO
        Duplicate code in drawElements of ChooseLevelViewer and MainMenuViewer
        Idea (do later): drawElements calls drawHeader() and drawOptions()
        drawHeader() implemented in subclasses
        */
        gui.drawText(new Position(5, 5), "CHOOSE LEVEL", "#FFFFFF");
        optionsViewer.drawOptions(gui);
    }
}
