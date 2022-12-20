package ldts.pacman;

import ldts.pacman.application.state.MainMenuState;
import ldts.pacman.gui.LanternaGUI;
import ldts.pacman.model.menu.MainMenu;
import ldts.pacman.application.state.State;
import ldts.pacman.sound.observer.SoundSelection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private static final int FPS = 60;
    private static final int FRAME_TIME = 1000 / FPS;
    private final LanternaGUI gui;
    private State state;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        int width = 20, height = 23;
        this.gui = new LanternaGUI(width, height);
        this.state = new MainMenuState(new MainMenu(new SoundSelection()));
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException, UnsupportedAudioFileException, LineUnavailableException {
        Game game = new Game();
        game.run();
    }
    public void setState(State state) {
        this.state = state;
    }
    public void run() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = FRAME_TIME - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
                // FPS achieved, ignore exception
            }
        }
        gui.close();
    }
}
