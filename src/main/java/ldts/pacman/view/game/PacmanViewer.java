package ldts.pacman.view.game;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.elements.Pacman;

public class PacmanViewer implements ElementViewer<Pacman> {
    @Override
    public void draw(Pacman pacman, GUI gui) {
        gui.drawPacman(pacman.getPosition(), pacman.getDirection());
        gui.drawScore(pacman.getScore());
        gui.drawHealth(pacman.getHealth());
    }
}
