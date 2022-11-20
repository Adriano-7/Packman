package ldts.packman.control;

import ldts.packman.model.game.Position;
import ldts.packman.model.game.elements.Pacman;

public class PacmanController {
    private Pacman pacman;
    public PacmanController(Pacman pacman) {
        this.pacman = pacman;
    }
    public void movePacman(Position position) {
        pacman.setPosition(position);   // no checking done
    }
    public void movePacmanUp() {
        movePacman(pacman.getPosition().getUp());
    }
    public void movePacmanDown() {
        movePacman(pacman.getPosition().getDown());
    }
    public void movePacmanLeft() {
        movePacman(pacman.getPosition().getLeft());
    }
    public void movePacmanRight() {
        movePacman(pacman.getPosition().getRight());
    }
    public Pacman getPacman() {
        return this.pacman;
    }
}
