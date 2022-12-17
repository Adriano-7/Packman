package ldts.pacman.view.game;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.elements.PowerUp;

public class PowerUpViewer implements ElementViewer<PowerUp> {
    @Override
    public void draw(PowerUp element, GUI gui) {
        gui.drawPowerUp(element.getPosition());
    }
}
