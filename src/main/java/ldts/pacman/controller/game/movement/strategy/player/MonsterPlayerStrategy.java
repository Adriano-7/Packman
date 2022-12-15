package ldts.pacman.controller.game.movement.strategy.player;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.elements.MovableElement;

import java.util.List;

public class MonsterPlayerStrategy extends PlayerStrategy {
    public MonsterPlayerStrategy() {
        super(250);
    }
    @Override
    public void changeDirection(List<GUI.OPTION> options, MovableElement element) {
        for (GUI.OPTION option : options) {
            switch (option) {
                case UP2:
                    element.setDirection(new Position(0, -1));
                    break;
                case DOWN2:
                    element.setDirection(new Position(0, 1));
                    break;
                case LEFT2:
                    element.setDirection(new Position(-1, 0));
                    break;
                case RIGHT2:
                    element.setDirection(new Position(1, 0));
                    break;
            }
        }
    }
}
