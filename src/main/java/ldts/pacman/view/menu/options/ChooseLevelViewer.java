package ldts.pacman.view.menu.options;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.options.ChooseLevel;

public class ChooseLevelViewer extends MenuViewer<ChooseLevel> {
    public ChooseLevelViewer(ChooseLevel model, OptionsViewer optionsViewer) {
        super(model, optionsViewer);
    }
    @Override
    protected void drawHeader(GUI gui) {
        gui.drawText(new Position(5, 7), "CHOOSE LEVEL", "#FFFFFF");
    }
}
