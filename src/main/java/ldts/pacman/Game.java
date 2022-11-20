package ldts.pacman;

import ldts.pacman.gui.LanternaGUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.view.ArenaViewer;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;
    private Arena arena;
    public Game() throws IOException {
        int width = 80, height = 40;
        this.gui = new LanternaGUI(width, height);
        this.arena = new Arena(width, height);
    }
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();
    }
    public void run() throws IOException {
        ArenaViewer arenaViewer = new ArenaViewer();
        while (true) {
            arenaViewer.draw(arena, gui);
        }
    }
}
