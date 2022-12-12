package ldts.pacman.model.game.elements;

import ldts.pacman.controller.game.movement.strategy.MovementStrategy;
import ldts.pacman.model.game.arena.Arena;

public class MonsterPlayer extends MovableElement{
    private String color;
    private MovementStrategy strategy;
    public MonsterPlayer(int x, int y, String color) {
        super(x, y);
        this.color=color;
    }
    public MovementStrategy movementStrategy(Arena arena){
        if (strategy==null){
            // Modified Player Strategy
            // this.strategy= new PlayerStrategy(arena);
        }
        return this.strategy;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
