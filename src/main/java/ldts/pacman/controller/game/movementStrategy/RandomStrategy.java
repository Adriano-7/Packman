package ldts.pacman.controller.game.movementStrategy;


import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.*;

public class RandomStrategy extends MovementStrategy {
    public RandomStrategy(Arena arena) {
        super(arena);
    }

    @Override
    public boolean move(MovableElement element) {
        List<Position> directions = Arrays.asList(new Position(0, 1), new Position(0, -1),
                new Position(1, 0), new Position(-1, 0));

        List<Position> validDirections = new ArrayList<>();
        for (Position direction : directions) {
            if (!direction.equals(element.getDirection()) &&
                    !arena.isWall(element.getPosition().add(direction))) {
                validDirections.add(direction);
            }
        }
        if (validDirections.isEmpty()) return false;

        int n = (int) (Math.random() * validDirections.size());

        element.setDirection(validDirections.get(n));
        element.setPosition(element.getPosition().add(element.getDirection()));
        return true;
    }
}
        /*
    int cpt = 0;
    Iterator<String> it = list.iterator();
    while(it.hasNext()){
        it.next();
        if(indexes.contains(cpt)){
            it.remove();
        }
        cpt++;
    }




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
     */

