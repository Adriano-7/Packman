package ldts.pacman.control;

import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;

public class ArenaController {
    private Arena arena;
    private PacmanController pacmanController;
    private MonsterController monsterController;
    public ArenaController(Arena arena) {
        this.arena = arena;
        this.pacmanController = new PacmanController(arena.getPacman());
        //this.monsterController = new MonsterController();
    }
    // method for processing input ( ? )
}
