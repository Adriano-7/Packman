package ldts.pacman.application.state;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.game.ArenaControllerMultiplayer;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.game.ArenaViewerMultiplayer;

public class GameStateMultiplayer extends State<Arena> {
    public GameStateMultiplayer(Arena model) {
        super(model);
    }
    @Override
    protected Viewer<Arena> getViewer() { return new ArenaViewerMultiplayer(getModel());}
    @Override
    protected Controller<Arena> getController() {
        return new ArenaControllerMultiplayer(getModel());
    }
}
