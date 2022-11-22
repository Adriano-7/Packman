package ldts.pacman.control.game;

import ldts.pacman.Game;
import ldts.pacman.control.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;

public class PacmanController extends ArenaController {
    private long lastMovement;
    public enum Direction { NONE, UP, DOWN, LEFT, RIGHT }
    private Direction direction;
    public PacmanController(Arena model) {
        super(model);
        direction = Direction.NONE;
        lastMovement = 0;
    }
    public void movePacman(Position position) {
        getModel().getPacman().setPosition(position);   // no checking done
    }
    public void movePacmanUp() {
        movePacman(getModel().getPacman().getPosition().getUp());
    }
    public void movePacmanDown() {
        movePacman(getModel().getPacman().getPosition().getDown());
    }
    public void movePacmanLeft() {
        movePacman(getModel().getPacman().getPosition().getLeft());
    }
    public void movePacmanRight() {
        movePacman(getModel().getPacman().getPosition().getRight());
    }
    public void movePacmanInDirection() {
        switch (direction) {
            case UP: movePacmanUp(); break;
            case DOWN: movePacmanDown(); break;
            case LEFT: movePacmanLeft(); break;
            case RIGHT: movePacmanRight(); break;
        }
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public Pacman getPacman() {
        return getModel().getPacman();
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        switch (option) {
            case UP -> setDirection(Direction.UP);
            case DOWN -> setDirection(Direction.DOWN);
            case LEFT -> setDirection(Direction.LEFT);
            case RIGHT -> setDirection(Direction.RIGHT);
        }
        /*
        if (option == GUI.OPTION.UP) setDirection(Direction.UP);
        if (option == GUI.OPTION.DOWN) setDirection(Direction.DOWN);
        if (option == GUI.OPTION.LEFT) setDirection(Direction.LEFT);
        if (option == GUI.OPTION.RIGHT) setDirection(Direction.RIGHT);
        */
        if (time - lastMovement > 500 && this.direction != Direction.NONE) {
            movePacmanInDirection();
            lastMovement = time;
        }
    }
}
