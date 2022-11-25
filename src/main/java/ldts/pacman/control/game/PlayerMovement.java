package ldts.pacman.control.game;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MovableElement;
import ldts.pacman.model.game.elements.Pacman;

public class PlayerMovement extends MovementStrategy {
    public enum Direction { NONE, UP, DOWN, LEFT, RIGHT }
    private Direction direction;

    public PlayerMovement(Arena arena) {
        super(arena);
        this.direction = Direction.NONE;
    }

    public boolean movePlayer(Position position) {
        if (!arena.isWall(position)) {
            arena.getPacman().setPosition(position);
            if (arena.isMonster(position)) {
                Pacman pacman = arena.getPacman();
                pacman.decreaseHealth();
                super.resetPositions();
            }
            // TODO: (for later) if getModel().isPowerUp() -> ...
            return true;
        }
        return false;
    }

    public boolean movePlayerUp() {
        setDirection(Direction.UP);
        return movePlayer(arena.getPacman().getPosition().getUp());
    }
    public boolean movePlayerDown() {
        setDirection(Direction.DOWN);
        return movePlayer(arena.getPacman().getPosition().getDown());
    }
    public boolean movePlayerLeft() {
        setDirection(Direction.LEFT);
        return movePlayer(arena.getPacman().getPosition().getLeft());
    }
    public boolean movePlayerRight() {
        setDirection(Direction.RIGHT);
        return movePlayer(arena.getPacman().getPosition().getRight());
    }

    public boolean movePlayerInDirection() {
        switch (direction) {
            case UP: return movePlayerUp();
            case DOWN: return movePlayerDown();
            case LEFT: return movePlayerLeft();
            case RIGHT: return movePlayerRight();
        }
        return false;
    }
    public void changeDirection(GUI.OPTION option) {
        switch (option) {
            case UP -> setDirection(Direction.UP);
            case DOWN -> setDirection(Direction.DOWN);
            case LEFT -> setDirection(Direction.LEFT);
            case RIGHT -> setDirection(Direction.RIGHT);
        }
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean move(MovableElement element) {
        return movePlayerInDirection();
    }
}
