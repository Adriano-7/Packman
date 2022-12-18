package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import java.util.HashMap;
import java.util.Map;

public class PacmanStrategy extends PlayerMovementStrategy {
    public PacmanStrategy() {
        super(createOptionToDirectionMap(), 200);
    }
    private static Map<GUI.OPTION, Position> createOptionToDirectionMap() {
        Map<GUI.OPTION, Position> pacmanOptionToDirection = new HashMap<>();
        pacmanOptionToDirection.put(GUI.OPTION.UP, new Position(0, -1));
        pacmanOptionToDirection.put(GUI.OPTION.DOWN, new Position(0, 1));
        pacmanOptionToDirection.put(GUI.OPTION.LEFT, new Position(-1, 0));
        pacmanOptionToDirection.put(GUI.OPTION.RIGHT, new Position(1, 0));
        return pacmanOptionToDirection;
    }
}