package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.MovableElement;
import java.util.List;

public class PacmanStrategy extends PlayerStrategy {
    public PacmanStrategy() {
        super(200);
    }
    @Override
    public void changeDirection(List<GUI.OPTION> options, MovableElement element) {
        for(GUI.OPTION option: options) {
            switch (option) {
                case UP:
                    element.setDirection(new Position(0, -1));
                    break;
                case DOWN:
                    element.setDirection(new Position(0, 1));
                    break;
                case LEFT:
                    element.setDirection(new Position(-1, 0));
                    break;
                case RIGHT:
                    element.setDirection(new Position(1, 0));
                    break;
                default:
                    break;
            }
        }
    }
}
