package ldts.pacman.control.game;

import ldts.pacman.control.Controller;
import ldts.pacman.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
