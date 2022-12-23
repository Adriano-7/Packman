package ldts.pacman.application.state;

import ldts.pacman.Game;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.view.Viewer;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }
    public T getModel() {
        return model;
    }
    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();
    public void step(Game game, GUI gui, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        List<GUI.OPTION> options = gui.getNextOptions();
        controller.step(game, options, time);
        viewer.draw(gui);
    }
}
