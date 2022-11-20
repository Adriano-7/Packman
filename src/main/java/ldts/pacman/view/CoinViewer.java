package ldts.pacman.view;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
