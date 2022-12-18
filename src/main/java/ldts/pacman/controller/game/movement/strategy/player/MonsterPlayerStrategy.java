package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterPlayerStrategy extends PlayerMovementStrategy {
    public MonsterPlayerStrategy() {
        super(createOptionToDirectionMap(), 250);
    }
    private static Map<GUI.OPTION, Position> createOptionToDirectionMap() {
        Map<GUI.OPTION, Position> monsterOptionToDirection = new HashMap<>();
        monsterOptionToDirection.put(GUI.OPTION.UP2, new Position(0, -1));
        monsterOptionToDirection.put(GUI.OPTION.DOWN2, new Position(0, 1));
        monsterOptionToDirection.put(GUI.OPTION.LEFT2, new Position(-1, 0));
        monsterOptionToDirection.put(GUI.OPTION.RIGHT2, new Position(1, 0));
        return monsterOptionToDirection;
    }
}
