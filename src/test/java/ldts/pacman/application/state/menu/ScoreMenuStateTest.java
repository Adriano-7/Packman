package ldts.pacman.application.state.menu;

import ldts.pacman.controller.menu.ScoreMenuController;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.menu.ScoreMenu;
import ldts.pacman.view.menu.ScoreMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;

public class ScoreMenuStateTest {
    private ScoreMenuState scoreMenuState;
    private ScoreMenu scoreMenu;
    @BeforeEach
    public void setUp() {
        try { scoreMenu = new ScoreMenu(); }
        catch (IOException e) { fail(); }
        scoreMenuState = new ScoreMenuState(scoreMenu);
    }
    @Test
    public void getModel(){
        assertEquals(scoreMenu, scoreMenuState.getModel());
    }
    @Test
    public void getViewer(){
        assertEquals(ScoreMenuViewer.class, scoreMenuState.getViewer().getClass());
    }
    @Test
    public void getController(){
        assertEquals(ScoreMenuController.class, scoreMenuState.getController().getClass());
    }
    @Test
    public void step() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        GUI gui = Mockito.mock(GUI.class);
        scoreMenuState.step(null, gui, 0);

        Mockito.verify(gui, times(1)).getNextOptions();
    }
}
