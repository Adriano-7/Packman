package ldts.pacman.model.game.elements;

import ldts.pacman.control.Controller;
import ldts.pacman.control.game.GameController;
import ldts.pacman.control.game.MovementStrategy;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.view.Viewer;

import java.awt.*;

public abstract class Monster extends MovableElement {
    public Monster(int x, int y){
        super(x,y);
    }
    public abstract MovementStrategy getMovementStrategy(Arena arena);
    public abstract String getColor();
}
