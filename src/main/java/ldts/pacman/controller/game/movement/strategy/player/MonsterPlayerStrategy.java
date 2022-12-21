package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;

public class MonsterPlayerStrategy extends PlayerMovementStrategy {
    public MonsterPlayerStrategy() {
        super(GUI.OPTION.UP2, GUI.OPTION.DOWN2, GUI.OPTION.LEFT2, GUI.OPTION.RIGHT2, 250);
    }
}
