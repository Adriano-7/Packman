package ldts.pacman.control;

import ldts.pacman.model.game.arena.Arena;

public class ArenaController {
    private Arena arena;
    private PacmanController pacmanController;
    public ArenaController(Arena arena) {
        this.arena = arena;
        this.pacmanController = new PacmanController(arena.getPacman());
    }
    // method for processing input ( ? )
}
