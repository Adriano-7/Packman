package ldts.pacman.view.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.view.Viewer;

public class SaveScoreViewer extends Viewer<SaveScore> {
    public SaveScoreViewer(SaveScore model) {
        super(model);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(2, 5), "GAME OVER", "#FFFFFF");
        gui.drawText(new Position(2, 7), "YOUR SCORE:", "#FFFFFF");
        String score = Integer.toString(getModel().getScore());
        gui.drawText(new Position(13, 7), score, "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(2, 9 + i),
                    getModel().getOption(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
