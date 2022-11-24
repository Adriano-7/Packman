package ldts.pacman.control.game;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Pacman;

import java.lang.management.PlatformLoggingMXBean;

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
        // processar input (mudar direção)
        // verificar tempo
        // mover o pacman
        playerMovement.changeDirection(option);

        if (time - lastMovement > 500 && playerMovement.move(getPacman())) {
            lastMovement = time;
            //collectCoin(position);
        }
    }
}
