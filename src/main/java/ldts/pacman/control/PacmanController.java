package ldts.pacman.control;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;

public class PacmanController {
    private Arena arena;
    enum Direction { NONE, UP, DOWN, LEFT, RIGHT }
    private Direction direction;
    public PacmanController(Arena arena) {
        this.arena = arena;
        this.direction = Direction.NONE;
    }
    public void movePacman(Position position) {
        arena.getPacman().setPosition(position);   // no checking done
    }
    public void movePacmanUp() {
        movePacman(arena.getPacman().getPosition().getUp());
    }
    public void movePacmanDown() {
        movePacman(arena.getPacman().getPosition().getDown());
    }
    public void movePacmanLeft() {
        movePacman(arena.getPacman().getPosition().getLeft());
    }
    public void movePacmanRight() {
        movePacman(arena.getPacman().getPosition().getRight());
    }
    public void movePacmanInDirection() {
        switch (direction) {
            case UP -> movePacmanUp();
            case DOWN -> movePacmanDown();
            case LEFT -> movePacmanLeft();
            case RIGHT -> movePacmanRight();
        }
    }
    public void changeDirection(GUI.OPTION option) {
        switch (option) {
            case UP -> this.direction = Direction.UP;
            case DOWN -> this.direction = Direction.DOWN;
            case LEFT -> this.direction = Direction.LEFT;
            case RIGHT -> this.direction = Direction.RIGHT;
        }
    }
    public Pacman getPacman() {
        return this.arena.getPacman();
    }
}
