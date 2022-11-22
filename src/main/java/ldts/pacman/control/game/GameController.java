package ldts.pacman.control.game;

import ldts.pacman.Game;
import ldts.pacman.control.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.state.MenuState;

public class GameController extends ArenaController {
    private PacmanController pacmanController;

    public GameController(Arena arena) {
        super(arena);
        this.pacmanController = new PacmanController(arena);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        if (option == GUI.OPTION.QUIT || getModel().getPacman().getHealth() == 0) {
            System.out.println("Game Over");
            game.setState(new MenuState(new Menu()));
        }
        else {
            pacmanController.step(game, option, time);
        }
    }
}
