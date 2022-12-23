package ldts.pacman.application.state;

import ldts.pacman.controller.Controller;
import ldts.pacman.controller.game.ArenaController;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.view.Viewer;
import ldts.pacman.view.game.ArenaViewer;

public class GameState extends State<Arena> {
    public GameState(Arena model) {
        super(model);
    }
    @Override
    protected Viewer<Arena> getViewer() { return new ArenaViewer(getModel());}
    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
