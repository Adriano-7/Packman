package ldts.pacman.view.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.view.Viewer;

public class ChooseLevelViewer extends Viewer<ChooseLevel> {
    public ChooseLevelViewer(ChooseLevel model) {
        super(model);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "CHOOSE LEVEL", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getOption(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
