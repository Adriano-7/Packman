package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.state.MenuState;

public class ArenaController extends GameController {
    private PacmanController pacmanController;
    private MonsterController monsterController;
    public ArenaController(Arena arena) {
        super(arena);
        this.pacmanController = new PacmanController(arena);
        this.monsterController = new MonsterController(arena);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) {
        if (option == GUI.OPTION.QUIT || getModel().getPacman().getHealth() == 0) {
            // TODO: ask for name and update scores file
            // getModel().getPacman().getScore()
            game.setState(new MenuState(new Menu()));
        }
        else {
            pacmanController.step(game, option, time);
            monsterController.step(game, option, time);
        }
    }
}
