package ldts.packman.view;

import ldts.packman.gui.GUI;
import ldts.packman.model.game.elements.Pacman;

public class PacmanViewer {
    public void draw(Pacman pacman, GUI gui) {
        gui.drawPacman(pacman.getPosition());
    }
}
