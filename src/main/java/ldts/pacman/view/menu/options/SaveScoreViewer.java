package ldts.pacman.view.menu.options;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.menu.options.SaveScore;

public class SaveScoreViewer extends MenuViewer<SaveScore> {
    public SaveScoreViewer(SaveScore model, OptionsViewer optionsViewer) {
        super(model, optionsViewer);
    }
    @Override
    protected void drawHeader(GUI gui) {
        String color = "#FFFFFF";
        gui.drawText(new Position(2, 5), "GAME OVER", color);
        gui.drawText(new Position(2, 7), "YOUR SCORE:" + getModel().getScore(), color);
    }
}
