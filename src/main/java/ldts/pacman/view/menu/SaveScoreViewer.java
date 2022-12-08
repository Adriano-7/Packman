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
        gui.drawText(new Position(1, 3), "GAME OVER", "#FF00FF");
        gui.drawText(new Position(1, 5), "SAVE SCORE", "#FF00FF");
        gui.drawText(new Position(1, 6),  "  Q. QUIT", "#FF00FF");
        gui.drawText(new Position(1, 7), "  ENTER. SAVE", "#FF00FF");

        gui.drawText(new Position(1, 9), "TIME - SCORE", "#FF00FF");
        String timeAndScore = getModel().getTimeStamp() + " - " + getModel().getScore();
        gui.drawText(new Position(1, 10), timeAndScore, "#FF00FF");
    }
}
