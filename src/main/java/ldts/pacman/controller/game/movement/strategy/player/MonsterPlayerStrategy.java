package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterPlayerStrategy extends PlayerMovementStrategy {
    public MonsterPlayerStrategy() {
        super(GUI.OPTION.UP2, GUI.OPTION.DOWN2, GUI.OPTION.LEFT2, GUI.OPTION.RIGHT2, 250);
    }
}
