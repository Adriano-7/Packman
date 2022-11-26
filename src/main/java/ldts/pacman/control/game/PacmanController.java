package ldts.pacman.control.game;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Coin;
import ldts.pacman.model.game.elements.Pacman;

import java.lang.management.PlatformLoggingMXBean;
import java.util.List;

public class PacmanController extends GameController {
    private long lastMovement;
    private PlayerMovement playerMovement;
    public PacmanController(Arena model) {
        super(model);
        playerMovement = new PlayerMovement(model);
        lastMovement = 0;
    }
    public Pacman getPacman() {
        return getModel().getPacman();
    }

    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        playerMovement.changeDirection(option);
        if (time - lastMovement > 200 && playerMovement.move(getPacman())) {
            lastMovement = time;
            collectCoin(getModel().getPacman().getPosition());
        }
    }
    private void collectCoin(Position position) {
        List<Coin> coins = getModel().getCoins();
        for (Coin coin: coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                getPacman().increaseScore();
                break;
            }
        }
    }
}
