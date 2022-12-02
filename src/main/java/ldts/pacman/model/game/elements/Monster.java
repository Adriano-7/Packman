package ldts.pacman.model.game.elements;

import ldts.pacman.controller.game.MovementStrategy;
import ldts.pacman.model.game.arena.Arena;

public abstract class Monster extends MovableElement {
    public Monster(int x, int y){
        super(x,y);
    }
    public abstract MovementStrategy getMovementStrategy(Arena arena);
    public abstract String getColor();
}
