package ldts.pacman.view.menu;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.view.Viewer;

import java.util.List;

public class ScoreMenuViewer extends Viewer<ScoreMenu> {
    public ScoreMenuViewer(ScoreMenu model) {
        super(model);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "TOP 10 SCORES", "#FFFFFF");
        List<String> scores = getModel().getLines();
        for (int i = 0; i < scores.size(); i++) {
            // TODO: display scores according to window height/width (or just do this better)
            // Also have to choose a color
            gui.drawText(new Position(10, 10 + (i + 1)),
                    scores.get(i), "#FFFF00");
        }
    }
}
