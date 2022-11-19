package ldts.packman.view;

import ldts.packman.gui.GUI;
import ldts.packman.model.game.arena.Arena;

public class ArenaViewer {
    private PacmanViewer pacmanViewer;
    public ArenaViewer() {
        pacmanViewer = new PacmanViewer();
    }
    public void draw(Arena arena, GUI gui) {
        pacmanViewer.draw(arena.getPacman(), gui);
    }
}
