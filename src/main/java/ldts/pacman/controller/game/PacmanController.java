package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.controller.game.movement.strategy.PlayerStrategy;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Coin;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.Pacman;

import java.util.List;

public class PacmanController extends GameController {
    private long lastMovement;
    private PlayerStrategy playerStrategy;
    public PacmanController(Arena model) {
        super(model);
        playerStrategy = new PlayerStrategy();
        lastMovement = 0;
    }
    public Pacman getPacman() {
        return getModel().getPacman();
    }

    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        playerStrategy.changeDirection(option, getPacman());
        Arena arena = getModel();
        if (time - lastMovement > 200 && playerStrategy.move(getPacman(), arena)) {
            lastMovement = time;
            Monster monster = arena.getCollidingMonster(getPacman().getPosition());
            if (monster != null) {
                monster.getHit(arena);
                return;
            }
            collectCoin(getPacman().getPosition());
            // TODO: (for later) if getModel().isPowerUp(Position) -> ...
            // if collectPowerUp(getModel().getPacman().getPosition())
            //      for monster: monsters -> monster.setState(new ScaredState())
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
