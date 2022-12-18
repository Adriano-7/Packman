package ldts.pacman.view.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.view.Viewer;

public class ChooseLevelViewer extends MenuViewer<ChooseLevel> {
    public ChooseLevelViewer(ChooseLevel model, OptionsViewer optionsViewer) {
        super(model, optionsViewer);
    }
    @Override
    protected void drawHeader(GUI gui) {
        gui.drawText(new Position(5, 5), "CHOOSE LEVEL", "#FFFFFF");
    }
}