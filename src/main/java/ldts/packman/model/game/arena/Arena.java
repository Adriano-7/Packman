package ldts.packman.model.game.arena;

import ldts.packman.control.PacmanController;
import ldts.packman.model.game.elements.Pacman;
import ldts.packman.view.PacmanViewer;

public class Arena {
    private final int width;
    private final int height;
    private Pacman pacman;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        pacman = new Pacman(5, 5);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Pacman getPacman() {
        return pacman;
    }
}
