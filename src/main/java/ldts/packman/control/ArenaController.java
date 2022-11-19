package ldts.packman.control;

import ldts.packman.model.game.arena.Arena;

public class ArenaController {
    private Arena arena;
    private PacmanController pacmanController;
    public ArenaController(Arena arena) {
        this.arena = arena;
        this.pacmanController = new PacmanController(arena.getPacman());
    }
    // method for processing input ( ? )
}
