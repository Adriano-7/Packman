package ldts.pacman;

import ldts.pacman.gui.LanternaGUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.state.GameState;
import ldts.pacman.state.MenuState;
import ldts.pacman.state.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        int width = 60, height = 30;
        this.gui = new LanternaGUI(width, height);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        game.run();
    }
    public void setState(State state) {
        this.state = state;
    }
    public void run() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }
}