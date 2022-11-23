package ldts.pacman.state;

import ldts.pacman.control.Controller;
import ldts.pacman.control.game.ArenaController;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.view.game.ArenaViewer;
import ldts.pacman.view.Viewer;

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
