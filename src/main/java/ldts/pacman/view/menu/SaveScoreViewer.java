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
        gui.drawText(new Position(3, 3), "GAME OVER", "#FF00FF");
        gui.drawText(new Position( 3, 5), "SAVE SCORE (q. QUIT; ENTER. SAVE)", "#FF00FF");

        gui.drawText(new Position(3, 7), "TIME - SCORE", "#FF00FF");
        String timeAndScore = getModel().getTimeStamp() + " - " + getModel().getScore();
        gui.drawText(new Position(3, 8), timeAndScore, "#FF00FF");
    }
}
