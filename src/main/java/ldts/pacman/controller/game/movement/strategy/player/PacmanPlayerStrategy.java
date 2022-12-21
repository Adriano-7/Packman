package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;

public class PacmanPlayerStrategy extends PlayerMovementStrategy {
    public PacmanPlayerStrategy() {
        super(GUI.OPTION.UP, GUI.OPTION.DOWN, GUI.OPTION.LEFT, GUI.OPTION.RIGHT, 200);
    }
}
