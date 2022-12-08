package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.movementStrategy.PlayerStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Coin;
import ldts.pacman.model.game.elements.Pacman;

import java.util.List;

public class PacmanController extends GameController {
    private long lastMovement;
    private PlayerStrategy playerStrategy;
    public PacmanController(Arena model) {
        super(model);
        playerStrategy = new PlayerStrategy(model);
        lastMovement = 0;
    }
    public Pacman getPacman() {
        return getModel().getPacman();
    }

    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        playerStrategy.changeDirection(option);
        if (time - lastMovement > 200 && playerStrategy.move(getPacman())) {
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
