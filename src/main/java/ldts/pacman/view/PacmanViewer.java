package ldts.pacman.view;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.elements.Pacman;

public class PacmanViewer {
    public void draw(Pacman pacman, GUI gui) {
        gui.drawPacman(pacman.getPosition());
    }
}
