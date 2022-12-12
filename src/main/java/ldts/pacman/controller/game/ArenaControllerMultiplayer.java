package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.MonsterPlayer;
import ldts.pacman.model.menu.SaveScore;

public class ArenaControllerMultiplayer extends ArenaController {
    public ArenaControllerMultiplayer(Arena arena) {
        super(arena);
        addController(new MonsterPlayerController(arena));
    }
}
