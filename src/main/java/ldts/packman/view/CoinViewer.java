package ldts.packman.view;

import ldts.packman.gui.GUI;
import ldts.packman.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
