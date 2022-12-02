package ldts.pacman.controller.game;

import ldts.pacman.controller.Controller;
import ldts.pacman.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
