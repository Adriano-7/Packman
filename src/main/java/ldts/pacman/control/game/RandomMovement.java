package ldts.pacman.control.game;


import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class RandomMovement implements MovementStrategy {
    private Arena arena;
    public RandomMovement(Arena arena) {
        this.arena = arena;
    }
    @Override
    public void move(Monster monster) {
        boolean moved = false;
        while(!moved) {
            Position toMove = monster.getPosition().getRandomNeighbour();
            if (!arena.isWall(toMove)) {
                monster.setPosition(toMove);
                moved = true;
                if (arena.getPacman().getPosition().equals(monster.getPosition())) {
                    arena.getPacman().decreaseHealth();
                }
            }
        }
    }
}
