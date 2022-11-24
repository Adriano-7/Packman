package ldts.pacman.control.game;


import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.HashSet;
import java.util.Set;

public class RandomMovement extends MovementStrategy {
    public RandomMovement(Arena arena) {
        super(arena);
    }
    @Override
    public boolean move(MovableElement monster) {
        Set<Position> reachedPositions = new HashSet<>();

        while(reachedPositions.size()<4) {
            Position toMove = monster.getPosition().getRandomNeighbour();
            reachedPositions.add(toMove);
            if (!arena.isWall(toMove)) {
                monster.setPosition(toMove);
                if (arena.getPacman().getPosition().equals(monster.getPosition())) {
                    arena.getPacman().decreaseHealth();
                    super.resetPositions();
                }
                return true;
            }
        }
        return false;
    }
}
