package ldts.pacman.control.game;

import ldts.pacman.Game;
import ldts.pacman.control.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;

import java.io.IOException;

public abstract class ArenaController extends Controller<Arena> {
    public ArenaController(Arena arena) {
        super(arena);
    }
}
