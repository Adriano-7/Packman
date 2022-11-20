package ldts.packman.view;

import ldts.packman.gui.GUI;
import ldts.packman.model.game.elements.Pacman;
import ldts.packman.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
