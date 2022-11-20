package ldts.pacman.control;

import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.Pacman;

public class PacmanController {
    private Pacman pacman;
    enum Direction { NONE, UP, DOWN, LEFT, RIGHT }
    private Direction direction;
    public PacmanController(Pacman pacman) {
        this.pacman = pacman;
        this.direction = Direction.NONE;
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
    public void movePacmanInDirection() {
        switch (direction) {
            case UP: movePacmanUp(); break;
            case DOWN: movePacmanDown(); break;
            case LEFT: movePacmanLeft(); break;
            case RIGHT: movePacmanRight(); break;
            case NONE: default: break;
        }
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public Pacman getPacman() {
        return this.pacman;
    }
}
