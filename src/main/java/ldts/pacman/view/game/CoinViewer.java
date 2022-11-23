package ldts.pacman.view.game;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
