package ldts.pacman.control;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;

public class ArenaController {
    private Arena arena;
    private PacmanController pacmanController;
    public ArenaController(Arena arena) {
        this.arena = arena;
        this.pacmanController = new PacmanController(arena);
    }
    public void processInput(GUI.OPTION option) {
        if (option == GUI.OPTION.QUIT) {

        }
        pacmanController.changeDirection(option);
    }
    // method for processing input ( ? )
}
